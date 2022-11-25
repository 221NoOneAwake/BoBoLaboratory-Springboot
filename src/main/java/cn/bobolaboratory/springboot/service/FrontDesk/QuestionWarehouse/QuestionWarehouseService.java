package cn.bobolaboratory.springboot.service.FrontDesk.QuestionWarehouse;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface QuestionWarehouseService {
    /**
     * 查询所有题目库
     * @return 返回查询结果
     */
    ResponseResult queryAllOpenQuestionWarehouse();

    /**
     * 根据题目库Id获取题目
     * @param id 题目库Id
     * @return 返回查询结果
     */
    ResponseResult queryQuestionFromQuestionWarehouseById(Long id);
}
