package cn.bobolaboratory.springboot.service.BackStage.AllotService;

import cn.bobolaboratory.springboot.entity.Allot;
import cn.bobolaboratory.springboot.mapper.AllotMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class AllotServiceImpl implements AllotService {
    private final AllotMapper allotMapper;

    @Autowired
    public AllotServiceImpl(AllotMapper allotMapper) {
        this.allotMapper = allotMapper;
    }

    /**
     * 添加一项题目分配
     * @param allot 要添加的数据
     * @return 返回结果
     */
    @Override
    public ResponseResult addAllot(Allot allot) {
        try {
            allotMapper.addAllot(allot);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 查询所有分配
     * @return 返回结果
     */
    @Override
    public ResponseResult queryAllAllot() {
        return ResponseResult.success(allotMapper.queryAllAllot());
    }
}
