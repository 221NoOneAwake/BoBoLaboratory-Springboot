package cn.bobolaboratory.springboot.service.BackStage.ResultService;

import cn.bobolaboratory.springboot.utils.ResponseResult;

public interface ResultService {
    /**
     * 根据用户id获取所有相关答题记录
     * @param id 要查询的用户的id
     * @return 返回该用户的所有答题记录
     */
    ResponseResult queryResultByUserId(Long id);
}
