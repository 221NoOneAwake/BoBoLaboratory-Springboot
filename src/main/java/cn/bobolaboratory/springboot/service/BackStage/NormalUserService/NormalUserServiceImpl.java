package cn.bobolaboratory.springboot.service.BackStage.NormalUserService;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.mapper.NormalUserMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalUserServiceImpl implements NormalUserService {
    private final NormalUserMapper normalUserMapper;

    @Autowired
    public NormalUserServiceImpl(NormalUserMapper normalUserMapper) {
        this.normalUserMapper = normalUserMapper;
    }

    /**
     * 获取所有学生数据
     * @return 返回查询获得的信息
     */
    @Override
    public ResponseResult queryAllNormalUser() {
        try {
            List<NormalUser> list = normalUserMapper.queryAllNormalUser();
            return ResponseResult.success(list);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}