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
}
