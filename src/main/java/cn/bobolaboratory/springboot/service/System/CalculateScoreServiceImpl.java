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
        for (BlankQuestion blankQuestion : answerListDTO.getBlankQuestionList()) {
            BlankQuestion blankQuestionDTO = blankQuestionMapper.queryAnswerAndScoreById(blankQuestion.getId());
            if (blankQuestion.getAnswer().equals(blankQuestionDTO.getAnswer())) {
                score += blankQuestionDTO.getScore();
                Record record = new Record(blankQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), answerListDTO.getTimes(), blankQuestion.getAnswer(), (byte) 1, blankQuestionDTO.getScore());
                recordMapper.addRecord(record);
            }
        }
        for (ChoiceQuestion choiceQuestion : answerListDTO.getChoiceQuestionList()) {
            ChoiceQuestion choiceQuestionDTO = choiceQuestionMapper.queryAnswerAndScoreById(choiceQuestion.getId());
            if (choiceQuestion.getAnswer().equals(choiceQuestionDTO.getAnswer())) {
                score += choiceQuestionDTO.getScore();
                Record record = new Record(choiceQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), answerListDTO.getTimes(), choiceQuestion.getAnswer(), (byte) 1, choiceQuestionDTO.getScore());
                recordMapper.addRecord(record);
            }
        }
        for (JudgeQuestion judgeQuestion : answerListDTO.getJudgeQuestionList()) {
            JudgeQuestion judgeQuestionDTO = judgeQuestionMapper.queryAnswerAndScoreById(judgeQuestion.getId());
            if (judgeQuestion.getAnswer().equals(judgeQuestionDTO.getAnswer())) {
                score += judgeQuestionDTO.getScore();
                Record record = new Record(judgeQuestion.getId(), answerListDTO.getOpenId(), "填空题", answerListDTO.getDate(), answerListDTO.getTimes(), judgeQuestion.getAnswer(), (byte) 1, judgeQuestionDTO.getScore());
                recordMapper.addRecord(record);
            }
        }
        return ResponseResult.success(score / 10);
    }
}
