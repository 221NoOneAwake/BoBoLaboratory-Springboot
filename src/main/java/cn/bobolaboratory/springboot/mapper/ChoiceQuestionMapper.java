package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ChoiceQuestionMapper {
    /**
     * 新增选择题
     * @param choiceQuestion 要添加的题目
     */
    void addChoiceQuestion(ChoiceQuestion choiceQuestion);

    /**
     * 查询所有题目
     * @return 返回查询结果
     */
    List<ChoiceQuestion> queryAllChoiceQuestion();

    /**
     * 修改题目
     * @param choiceQuestion 要修改的内容
     */
    void updateChoiceQuestionById(ChoiceQuestion choiceQuestion);

    /**
     * 删除题目
     * @param id 要删除的题目的id
     */
    void deleteQuestionById(Long id);

    /**
     * 根据questionId获取题目和答案
     * @param questionId 题目库Id
     * @return 返回题目列表
     */
    List<ChoiceQuestion> queryQuestionAndAnswerByQuestionId(Long questionId);

    /**
     * 根据questionId获取Id和题目
     * @param questionId 题目库Id
     * @return 返回题目列表
     */
    List<ChoiceQuestion> queryIdAndQuestionByQuestionId(Long questionId);

    /**
     * 根据questionId查询Id
     * @param questionId 题目库id
     * @return 返回题目id列表
     */
    List<Long> queryIdByQuestionId(Long questionId);

    /**
     * 根据id获取答案和分值
     * @param id 题目id
     * @return 答案和分值
     */
    ChoiceQuestion queryAnswerAndScoreById(Long id);

    /**
     * 根据题目id获取题集id
     * @param id 题目id
     * @return 题目所属题集的id
     */
    Long queryQuestionWarehouseIdByQuestionId(Long id);
}
