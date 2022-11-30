package cn.bobolaboratory.springboot.service.FrontDesk.Record;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface RecordService {

    /**
     * 用户查询答题记录
     * @return 返回查询结果
     */
    ResponseResult queryRecordByUserId();
}
