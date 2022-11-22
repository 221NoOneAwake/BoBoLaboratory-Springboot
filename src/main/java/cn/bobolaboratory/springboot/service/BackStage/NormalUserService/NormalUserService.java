package cn.bobolaboratory.springboot.service.BackStage.NormalUserService;

import cn.bobolaboratory.springboot.utils.ResponseResult;

public interface NormalUserService {
    /**
     * 获取所有学生数据
     * @return 返回查询获得的信息
     */
    ResponseResult queryAllNormalUser();
}
