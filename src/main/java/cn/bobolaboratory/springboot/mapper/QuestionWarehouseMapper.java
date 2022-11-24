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
}
