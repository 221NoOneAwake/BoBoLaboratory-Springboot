package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.vo.QuestionSetInfoVo;
import cn.bobolaboratory.springboot.entity.QuestionSet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface QuestionSetMapper {
    /**
     * 新增题目集
     * @param questionSet 要添加的题目集
     */
    void insertQuestionSet(QuestionSet questionSet);

    /**
     * 获取最新一条插入数据的id
     * @return 最新一条插入数据的id
     */
    Long getLastInsertId();

    /**
     * 后台查询所有题目集
     * @return 返回查询结果
     */
    List<QuestionSet> selectAllQuestionSet();

    /**
     * 查询所有已开放题目集信息
     * @return 返回查询结果
     */
    List<QuestionSetInfoVo> selectOpenQuestionSetInfo();

    /**
     * 根据题集id开放题集
     * @param questionSetId 要开放的题集的id
     */
    void openQuestionSet(Long questionSetId);
}
