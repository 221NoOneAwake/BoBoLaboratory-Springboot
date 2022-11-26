package cn.bobolaboratory.springboot.service.FrontDesk.Question;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.mapper.BlankQuestionMapper;
import cn.bobolaboratory.springboot.mapper.ChoiceQuestionMapper;
import cn.bobolaboratory.springboot.mapper.JudgeQuestionMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private BlankQuestionMapper blankQuestionMapper;
    private ChoiceQuestionMapper choiceQuestionMapper;
    private JudgeQuestionMapper judgeQuestionMapper;

    @Autowired
    public QuestionServiceImpl(BlankQuestionMapper blankQuestionMapper, ChoiceQuestionMapper choiceQuestionMapper, JudgeQuestionMapper judgeQuestionMapper) {
        this.blankQuestionMapper = blankQuestionMapper;
        this.choiceQuestionMapper = choiceQuestionMapper;
        this.judgeQuestionMapper = judgeQuestionMapper;
    }

    /**
     * 评分
     * @param answerListDTO 答案列表
     * @return 返回成绩
     */
    @Override
    public ResponseResult checkAnswer(AnswerListDTO answerListDTO) {
        int score = 0;
        for (BlankQuestion blankQuestion : answerListDTO.getBlankQuestionList()) {
            BlankQuestion blankQuestionDTO = blankQuestionMapper.queryAnswerAndScoreById(blankQuestion.getId());
            if (blankQuestion.getAnswer().equals(blankQuestionDTO.getAnswer())) {
                score += blankQuestionDTO.getScore();
            }
        }
        for (ChoiceQuestion choiceQuestion : answerListDTO.getChoiceQuestionList()) {
            ChoiceQuestion choiceQuestionDTO = choiceQuestionMapper.queryAnswerAndScoreById(choiceQuestion.getId());
            if (choiceQuestion.getAnswer().equals(choiceQuestionDTO.getAnswer())) {
                score += choiceQuestionDTO.getScore();
            }
        }
        for (JudgeQuestion judgeQuestion : answerListDTO.getJudgeQuestionList()) {
            JudgeQuestion judgeQuestionDTO = judgeQuestionMapper.queryAnswerAndScoreById(judgeQuestion.getId());
            if (judgeQuestion.getAnswer().equals(judgeQuestionDTO.getAnswer())) {
                score += judgeQuestionDTO.getScore();
            }
        }
        return ResponseResult.success(score);
    }
}
