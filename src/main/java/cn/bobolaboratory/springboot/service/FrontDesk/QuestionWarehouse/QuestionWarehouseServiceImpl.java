package cn.bobolaboratory.springboot.service.FrontDesk.QuestionWarehouse;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.mapper.QuestionWarehouseMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 查询已开放题目库
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryAllOpenQuestionWarehouse() {
        try {
            List<QuestionWarehouse> list = questionWarehouseMapper.queryAllOpenQuestionWarehouse();
            return ResponseResult.success(list);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
