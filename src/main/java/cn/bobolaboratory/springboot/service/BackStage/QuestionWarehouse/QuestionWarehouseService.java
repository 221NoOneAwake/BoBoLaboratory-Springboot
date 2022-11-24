package cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface QuestionWarehouseService {
    /**
     * 新建题目库并添加题目
     * @param questionWarehouse 要添加的题目库
     * @return 返回结果
     */
    ResponseResult addQuestionWarehouse(QuestionWarehouse questionWarehouse);

    /**
     * 查询所有题目库
     * @return 返回查询结果
     */
    ResponseResult queryAllQuestionWarehouse();

    /**
     * 开放新的题目库
     * @param id 要开放的题目库
     * @return 返回结果
     */
    ResponseResult openQuestionWarehouseById(Long id);

    /**
     * 根据id获取题目库中的题目
     * @param id 题目库id
     * @return 返回结果
     */
    ResponseResult queryQuestionFromQuestionWarehouseById(Long id);

    /**
     * 根据id删除题目库
     * @param id 题目库id
     * @return 返回结果
     */
    ResponseResult deleteQuestionWarehouseAndQuestionById(Long id);
}
