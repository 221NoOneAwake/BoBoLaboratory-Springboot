package cn.bobolaboratory.springboot.service.BackStage.NormalUserService;

import cn.bobolaboratory.springboot.dto.NormalUserUpdateRequest;
import cn.bobolaboratory.springboot.dto.QueryNormalUserByGroupRequest;
import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.mapper.NormalUserMapper;
import cn.bobolaboratory.springboot.mapper.RecordMapper;
import cn.bobolaboratory.springboot.mapper.ResultMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class NormalUserServiceImpl implements NormalUserService {
    private final NormalUserMapper normalUserMapper;
    private final RecordMapper recordMapper;
    private final ResultMapper resultMapper;

    @Autowired
    public NormalUserServiceImpl(NormalUserMapper normalUserMapper, RecordMapper recordMapper, ResultMapper resultMapper) {
        this.normalUserMapper = normalUserMapper;
        this.recordMapper = recordMapper;
        this.resultMapper = resultMapper;
    }

    /**
     * 根据姓名查询学生信息
     * @param name 姓名
     * @return 返回班级列表
     */
    @Override
    public ResponseResult queryNormalUserByName(String name) {
        try {
            return ResponseResult.success(normalUserMapper.queryNormalUserByName(name));
        } catch (RuntimeException e) {
            return ResponseResult.error("根据姓名查询学生信息失败\n" + e.getMessage());
        }
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

    /**
     * 获取班级列表
     * @return 返回班级列表
     */
    @Override
    public ResponseResult queryGroupList() {
        try {
            return ResponseResult.success(normalUserMapper.queryGroupList());
        } catch (RuntimeException e) {
            return ResponseResult.error("获取班级列表失败!\n" + e.getMessage());
        }
    }

    /**
     * 根据班级查询学生信息
     * @param queryNormalUserByGroupRequest 班级
     * @return 返回班级列表
     */
    @Override
    public ResponseResult queryNormalUserByGroup(QueryNormalUserByGroupRequest queryNormalUserByGroupRequest) {
        try {
            return ResponseResult.success(normalUserMapper.queryNormalUserByGroup(queryNormalUserByGroupRequest));
        } catch (RuntimeException e) {
            return ResponseResult.error("根据班级查询学生信息失败!\n" + e.getMessage());
        }
    }

    /**
     * 更新学生信息
     * @param normalUserUpdateRequest 要更新的学生的信息
     * @return 返回结果
     */
    @Override
    public ResponseResult updateNormalUserById(NormalUserUpdateRequest normalUserUpdateRequest) {
        try {
            normalUserMapper.updateNormalUserById(normalUserUpdateRequest);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 删除学生信息
     * @param id 要删除的学生的id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteNormalUserById(Long id) {
        System.out.println(id);
        try {
            recordMapper.deleteRecordByUserId(id);
            resultMapper.deleteResultByUserId(id);
            normalUserMapper.deleteNormalUserById(id);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
