package cn.bobolaboratory.springboot.service.BackStage.QuestionService;

import cn.bobolaboratory.springboot.dto.QuestionAddRequest;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.mapper.QuestionMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    /**
     * 添加单道题目
     * @param questionAddRequest 要添加的题目
     * @return 返回结果
     */
    @Override
    public ResponseResult addSingleQuestion(QuestionAddRequest questionAddRequest) {
        try {
            // 0 判断题 1 选择题
            if (questionAddRequest.getType() == 0) {
                questionMapper.insertJudgeQuestion(questionAddRequest);
            } else {
                questionMapper.insertChoiceQuestion(questionAddRequest);
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }

    /**
     * 管理员获取题目详情
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 答案 分值
     */
    public ResponseResult queryQuestionByQuestionSetIdFromBackEnd(Long questionSetId) {
        List<Question> questionList;
        try {
            questionList = questionMapper.selectQuestionByQuestionSetIdFromBackEnd(questionSetId);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionList);
    }

    /**
     * 修改题目信息
     * @param question 要修改的题目的信息
     */
    public ResponseResult updateQuestionByQuestionId(Question question) {
        try {
            questionMapper.updateQuestionByQuestionId(question);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }
}
