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
}
