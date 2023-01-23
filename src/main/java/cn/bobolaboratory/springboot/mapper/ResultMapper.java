package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ResultMapper {
    /**
     * 获取用户已答题次数和最高成绩
     * @param userId 用户id
     * @param questionSetId 题集id
     * @return 返回用户在该题集的答题次数
     */
    Result countSubmitTimesByUserIdAndQuestionSetId(Long userId, Long questionSetId);

    /**
     * 添加记录
     * @param result 学生首次答题
     */
    void insertResult(Result result);

    /**
     * 根据用户id获取所有相关答题记录
     * @param userId 用户id
     * @return 返回该用户的所有答题记录
     */
    List<Result> selectResultByUserId(Long userId);

    /**
     * 更新成绩
     * @param result 学生非首次答题更新成绩
     */
    void updateResult(Result result);
}
