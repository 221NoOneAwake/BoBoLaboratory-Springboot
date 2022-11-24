package cn.bobolaboratory.springboot.service.BackStage.NormalUserService;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.utils.ResponseResult;

public interface NormalUserService {
    /**
     * 获取所有学生数据
     * @return 返回查询获得的信息
     */
    ResponseResult queryAllNormalUser();

    /**
     * 更新学生信息
     * @param normalUser 要更新的学生信息
     * @return 返回结果
     */
    ResponseResult updateNormalUserById(NormalUser normalUser);

    /**
     * 删除学生信息
     * @param id 要删除的学生的id
     * @return 返回结果
     */
    ResponseResult deleteNormalUserById(Long id);
}
