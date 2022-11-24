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

    /**
     * 修改题目
     * @param choiceQuestion 要修改的内容
     * @return 返回结果
     */
    ResponseResult updateChoiceQuestion(ChoiceQuestion choiceQuestion);

    /**
     * 删除题目
     * @param id 要删除的题目的id
     * @return 返回结果
     */
    ResponseResult deleteQuestionById(Long id);
}
