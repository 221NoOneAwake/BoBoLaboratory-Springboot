package cn.bobolaboratory.springboot.service.System;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.entity.Record;
import cn.bobolaboratory.springboot.mapper.BlankQuestionMapper;
import cn.bobolaboratory.springboot.mapper.ChoiceQuestionMapper;
import cn.bobolaboratory.springboot.mapper.JudgeQuestionMapper;
import cn.bobolaboratory.springboot.mapper.RecordMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class CalculateScoreServiceImpl implements CalculateScoreService {
    private final BlankQuestionMapper blankQuestionMapper;
    private final ChoiceQuestionMapper choiceQuestionMapper;
    private final JudgeQuestionMapper judgeQuestionMapper;
    private final RecordMapper recordMapper;

    @Autowired
    public CalculateScoreServiceImpl(BlankQuestionMapper blankQuestionMapper, ChoiceQuestionMapper choiceQuestionMapper, JudgeQuestionMapper judgeQuestionMapper, RecordMapper recordMapper) {
        this.blankQuestionMapper = blankQuestionMapper;
        this.choiceQuestionMapper = choiceQuestionMapper;
        this.judgeQuestionMapper = judgeQuestionMapper;
        this.recordMapper = recordMapper;
    }

    /**
     * 评分
     * @param answerListDTO 答案列表
     * @return 返回成绩
     */
    @Override
    public ResponseResult calculateScoreAndSaveRecord(AnswerListDTO answerListDTO) {
        int score = 0;
        Record record;
        int times = recordMapper.checkTimesByOpenIdAndQuestionId(new Record(answerListDTO.getBlankQuestionList().get(0).getQuestionId(), answerListDTO.getOpenId()));
        for (BlankQuestion blankQuestion : answerListDTO.getBlankQuestionList()) {
            BlankQuestion blankQuestionAnswerAndScore = blankQuestionMapper.queryAnswerAndScoreById(blankQuestion.getId());
            if (blankQuestion.getAnswer().equals(blankQuestionAnswerAndScore.getAnswer())) {
                score += blankQuestionAnswerAndScore.getScore();
                record= new Record(blankQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, blankQuestion.getAnswer(), (byte) 1, blankQuestionAnswerAndScore.getScore());
                recordMapper.addRecord(record);
            }
            record = new Record(blankQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, blankQuestion.getAnswer(), (byte) 0, 0);
            recordMapper.addRecord(record);
        }
        for (ChoiceQuestion choiceQuestion : answerListDTO.getChoiceQuestionList()) {
            ChoiceQuestion choiceQuestionAnswerAndScore = choiceQuestionMapper.queryAnswerAndScoreById(choiceQuestion.getId());
            if (choiceQuestion.getAnswer().equals(choiceQuestionAnswerAndScore.getAnswer())) {
                score += choiceQuestionAnswerAndScore.getScore();
                record = new Record(choiceQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, choiceQuestion.getAnswer(), (byte) 1, choiceQuestionAnswerAndScore.getScore());
                recordMapper.addRecord(record);
            }
            record = new Record(choiceQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, choiceQuestion.getAnswer(), (byte) 0, 0);
            recordMapper.addRecord(record);
        }
        for (JudgeQuestion judgeQuestion : answerListDTO.getJudgeQuestionList()) {
            JudgeQuestion judgeQuestionAnswerAndScore = judgeQuestionMapper.queryAnswerAndScoreById(judgeQuestion.getId());
            if (judgeQuestion.getAnswer().equals(judgeQuestionAnswerAndScore.getAnswer())) {
                score += judgeQuestionAnswerAndScore.getScore();
                record = new Record(judgeQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, judgeQuestion.getAnswer(), (byte) 1, judgeQuestionAnswerAndScore.getScore());
                recordMapper.addRecord(record);
            }
            record = new Record(judgeQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), times + 1, judgeQuestion.getAnswer(), (byte) 0, 0);
            recordMapper.addRecord(record);
        }
        return ResponseResult.success(score / 10);
    }
}
