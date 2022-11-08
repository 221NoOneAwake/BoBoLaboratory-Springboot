package cn.bobolaboratory.springboot.service.BackStage.ChoiceQuestionService;

import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface ChoiceQuestionService {
    /**
     * 新增选择题
     * @param choiceQuestion 要添加的题目
     * @return 返回结果
     */
    ResponseResult addChoiceQuestion(ChoiceQuestion choiceQuestion);

    /**
     * 查询所有题目
     * @return 返回结果
     */
    ResponseResult queryAllChoiceQuestion();
}
