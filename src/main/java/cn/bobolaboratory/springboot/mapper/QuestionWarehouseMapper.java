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
}
