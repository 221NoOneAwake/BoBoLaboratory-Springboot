package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface RecordMapper {
    /**
     * 新增答题记录
     * @param record 要添加的记录
     */
    void insertRecord(Record record);

    /**
     * 用户查询题集的答题记录
     * @param questionSetId 题集id
     * @param userId 用户id
     * @return 返回 题目类型, 提交日期, 提交次数, 用户答案, 正确与否, 得分
     */
    List<Record> selectRecordByQuestionSetIdAndUserId(Long questionSetId, Long userId);

    /**
     * 根据userId删除该学生记录
     * @param userId 要删除的学生的id
     */
    void deleteRecordByUserId(Long userId);
}
