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
    void addRecord(Record record);

    /**
     * 查询所有记录
     * @return 返回查询结果
     */
    List<Record> queryAllRecord();

    /**
     * 查看已答题次数
     * @param record 答题人Id和题目Id
     * @return 返回已答题次数
     */
    Integer checkTimesByOpenIdAndQuestionId(Record record);
}
