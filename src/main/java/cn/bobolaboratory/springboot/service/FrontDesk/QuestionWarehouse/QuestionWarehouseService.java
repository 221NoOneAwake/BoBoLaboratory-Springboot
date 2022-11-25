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
    ResponseResult queryAllQuestionWarehouse();
}
