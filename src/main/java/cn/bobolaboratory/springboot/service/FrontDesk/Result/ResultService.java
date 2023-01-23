package cn.bobolaboratory.springboot.service.FrontDesk.Result;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface ResultService {
    /**
     * 根据用户id获取所有相关答题记录
     * @return 返回该用户的所有答题记录
     */
    ResponseResult queryResultByUserId();

    /**
     * 根据用户id和题集id获取已答题次数
     * @param questionSetId 题集id
     * @return 返回用户在题集的已答题次数
     */
    ResponseResult queryResidueSubmitTimesByUserIdAndQuestionSetId(Long questionSetId);
}
