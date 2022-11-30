package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface QuestionWarehouseMapper {
    /**
     * 新增一条题目库
     * @param questionWarehouse 要添加的题目库
     */
    void addQuestionWarehouse(QuestionWarehouse questionWarehouse);

    /**
     * 查询所有题目库
     * @return 返回查询结果
     */
    List<QuestionWarehouse> queryAllQuestionWarehouse();

    /**
     * 根据题目库名称获取id
     * @param name 要查询id的题目库名
     * @return 查询的id列表
     */
    List<Long> queryQuestionWarehouseIdByName(String name);

    /**
     * 开放新的题目库
     * @param id 要开放的题目库
     */
    void openQuestionWarehouseById(Long id);

    /**
     * 根据id删除题目库
     * @param id 要删除的题目库
     */
    void deleteQuestionWarehouseById(Long id);

    /**
     * 更新题目库基本信息
     * @param questionWarehouse 要更新的信息
     */
    void updateQuestionWarehouseInfo(QuestionWarehouse questionWarehouse);

    /**
     * 查询已开放的题库
     * @return 返回以开放的题库
     */
    List<QuestionWarehouse> queryAllOpenQuestionWarehouse();

    /**
     * 查看Id是否存在
     * @param id 要查询的id
     * @return 返回查询结果
     */
    Long checkIdExist(Long id);

    /**
     * 根据题目库id查询可答题次数
     * @param id 题目库id
     * @return 可答题次数
     */
    Integer queryTimesByQuestionWarehouseId(Long id);
}
