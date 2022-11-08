package cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.http.ResponseEntity;

/**
 * @author WhiteLeaf03
 */
public interface QuestionWarehouseService {
    /**
     * 新增一条题目库
     * @param questionWarehouse 要添加的题目库
     * @return 返回结果
     */
    ResponseResult addQuestionWarehouse(QuestionWarehouse questionWarehouse);

    /**
     * 查询所有题目库
     * @return 返回查询结果
     */
    ResponseResult queryAllQuestionWarehouse();
}
