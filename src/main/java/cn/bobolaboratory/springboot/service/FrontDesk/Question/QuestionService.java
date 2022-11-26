package cn.bobolaboratory.springboot.service.FrontDesk.Question;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface QuestionService {
    /**
     * 评分
     * @param answerListDTO 答案列表
     * @return 返回成绩
     */
    ResponseResult checkAnswer(AnswerListDTO answerListDTO);
}
