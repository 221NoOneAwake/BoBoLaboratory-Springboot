package cn.bobolaboratory.springboot.service.FrontDesk.Record;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface RecordService {

    /**
     * 用户查询答题记录
     * @param questionSetId 要查询的题集id
     * @return 返回查询结果
     */
    ResponseResult queryRecordByQuestionSetId(Long questionSetId);
}
