package cn.bobolaboratory.springboot.service.FrontDesk.QuestionService;

import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.entity.Record;
import cn.bobolaboratory.springboot.entity.Result;
import cn.bobolaboratory.springboot.mapper.QuestionMapper;
import cn.bobolaboratory.springboot.mapper.RecordMapper;
import cn.bobolaboratory.springboot.mapper.ResultMapper;
import cn.bobolaboratory.springboot.utils.RedisCache;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import cn.bobolaboratory.springboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionMapper questionMapper;
    private final ResultMapper resultMapper;
    private final RecordMapper recordMapper;
    private final RedisCache redisCache;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper, ResultMapper resultMapper, RecordMapper recordMapper, RedisCache redisCache) {
        this.questionMapper = questionMapper;
        this.resultMapper = resultMapper;
        this.recordMapper = recordMapper;
        this.redisCache = redisCache;
    }

    /**
     * 学生获取试卷
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 分值
     */
    public ResponseResult queryQuestionByQuestionSetIdFromFrontEnd(Long questionSetId) {
        List<Question> questionList;
        try {
            questionList = redisCache.getCacheObject("[ExamPaper]:" + questionSetId);
            if (Objects.isNull(questionList)) {
                questionList = questionMapper.selectQuestionByQuestionSetIdFromFrontEnd(questionSetId);
                redisCache.setCacheObject("[ExamPaper]:" + questionSetId, questionList, 30, TimeUnit.MINUTES);
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionList);
    }

    /**
     * 提交答案并打分
     * @param questionList 提交的答案列表
     * @return 返回成绩
     */
    @Override
    public ResponseResult submitAnswerAndCalculateScore(Long questionSetId, List<Question> questionList) {
        Long userId = UserUtil.getNormalUserId();
        Result result = resultMapper.countSubmitTimesByUserIdAndQuestionSetId(userId, questionSetId);
        Integer submitTimes;
        Integer maxScore;
        if (Objects.isNull(result)) {
            submitTimes = 1;
            maxScore = -1;
        } else {
            submitTimes = result.getSubmitTimes() + 1;
            maxScore = result.getMaxScore();
        }
        Long submitDate = System.currentTimeMillis();
        List<Question> answerInfoList;
        //获取标准答案
        try {
            answerInfoList = redisCache.getCacheObject("[ExamAnswer]:" + questionSetId);
            if (Objects.isNull(answerInfoList)) {
                answerInfoList = questionMapper.selectAnswerByQuestionSetId(questionSetId);
                redisCache.setCacheObject("[ExamAnswer]:" + questionSetId, answerInfoList, 30, TimeUnit.MINUTES);
            } else if (!redisCache.expire("[ExamAnswer]:" + questionSetId, 30, TimeUnit.MINUTES)){
                throw new RuntimeException("更新答案缓存时间失败");
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        int score = 0;
        for (int index = 0; index < questionList.size(); index++) {
            Question standardData = answerInfoList.get(index);
            Question submitData = questionList.get(index);
            if (submitData.getId().equals(standardData.getId()) && submitData.getAnswer().equals(standardData.getAnswer())) {
                //答案正确
                recordMapper.insertRecord(new Record(questionSetId, submitData.getId(), userId, standardData.getType(), submitDate, submitTimes, submitData.getAnswer(), true, standardData.getScore()));
                score += standardData.getScore();
            } else {
                //答案错误
                recordMapper.insertRecord(new Record(questionSetId, submitData.getId(), userId, standardData.getType(), submitDate, submitTimes, submitData.getAnswer(), false, 0));
            }
        }
        //保存成绩
        try {
            if (submitTimes == 1) {
                //第一次提交
                resultMapper.insertResult(new Result(questionSetId, userId, questionMapper.countTotalScoreByQuestionSetId(questionSetId), score, submitDate, submitTimes));
            } else {
                if (score > maxScore) {
                    maxScore = score;
                }
                resultMapper.updateResult(new Result(questionSetId, userId, maxScore, submitDate, submitTimes));
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(score);
    }
}
