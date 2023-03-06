package cn.bobolaboratory.springboot.service.FrontDesk.QuestionService;

import cn.bobolaboratory.springboot.dto.AnswerListPostRequest;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
public interface QuestionService {
    /**
     * 学生获取试卷
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 分值
     */
    ResponseResult queryQuestionByQuestionSetIdFromFrontEnd(Long questionSetId);

    /**
     * 提交答案并打分
     * @param answerListPostRequest 提交的答案
     * @return 返回成绩
     */
    ResponseResult submitAnswerAndCalculateScore(AnswerListPostRequest answerListPostRequest);
}
