package cn.bobolaboratory.springboot.mapper;

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
    void updateChoiceQuestion(ChoiceQuestion choiceQuestion);

    /**
     * 删除题目
     * @param id 要删除的题目的id
     */
    void deleteQuestionById(Long id);
}
