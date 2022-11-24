package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface BlankQuestionMapper {
    /**
     * 新增填空题
     * @param blankQuestion 要添加的题目
     */
    void addBlankQuestion(BlankQuestion blankQuestion);

    /**
     * 查询所有题目
     * @return 返回查询结果
     */
    List<BlankQuestion> queryAllBlankQuestion();

    /**
     * 修改题目
     * @param blankQuestion 要修改的内容
     */
    void updateBlankQuestion(BlankQuestion blankQuestion);

    /**
     * 删除题目
     * @param id 要删除的题目的id
     */
    void deleteQuestionById(Long id);

    /**
     * 根据questionId获取题目列表
     * @param questionId 题目库Id
     * @return 返回题目列表
     */
    List<BlankQuestion> queryQuestionByQuestionId(Long questionId);

    /**
     * 根据questionId查询Id
     * @param questionId 题目库id
     * @return 返回题目id列表
     */
    List<Long> queryIdByQuestionId(Long questionId);
}
