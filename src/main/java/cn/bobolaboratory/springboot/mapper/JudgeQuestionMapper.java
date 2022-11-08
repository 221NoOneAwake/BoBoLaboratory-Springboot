package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface JudgeQuestionMapper {
    /**
     * 新增判断题题
     * @param judgeQuestion 要添加的题目
     */
    void addJudgeQuestion(JudgeQuestion judgeQuestion);

    /**
     * 查询所有题目
     * @return 返回查询结果
     */
    List<JudgeQuestion> queryAllJudgeQuestion();
}
