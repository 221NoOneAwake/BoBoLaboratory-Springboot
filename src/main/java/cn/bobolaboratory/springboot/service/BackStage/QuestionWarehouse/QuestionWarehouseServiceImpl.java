package cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.mapper.QuestionWarehouseMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionWarehouseServiceImpl implements QuestionWarehouseService {
    private final QuestionWarehouseMapper questionWarehouseMapper;

    @Autowired
    public QuestionWarehouseServiceImpl(QuestionWarehouseMapper questionWarehouseMapper) {
        this.questionWarehouseMapper = questionWarehouseMapper;
    }

    /**
     * 新增一条题目库
     * @param questionWarehouse 要添加的题目库
     * @return 返回结果
     */
    @Override
    public ResponseResult addQuestionWarehouse(QuestionWarehouse questionWarehouse) {
        try {
            questionWarehouseMapper.addQuestionWarehouse(questionWarehouse);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
