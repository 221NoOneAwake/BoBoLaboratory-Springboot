package cn.bobolaboratory.springboot.service.BackStage.AllotService;

import cn.bobolaboratory.springboot.entity.Allot;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface AllotService {
    /**
     * 添加一项题目分配
     * @param allot 要添加的数据
     * @return 返回结果
     */
    ResponseResult addAllot(Allot allot);

    /**
     * 查询所有分配
     * @return 返回结果
     */
    ResponseResult queryAllAllot();
}
