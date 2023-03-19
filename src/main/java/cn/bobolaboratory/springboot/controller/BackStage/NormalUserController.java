package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.dto.NormalUserDeleteRequest;
import cn.bobolaboratory.springboot.dto.NormalUserUpdateRequest;
import cn.bobolaboratory.springboot.dto.QueryNormalUserByGroupRequest;
import cn.bobolaboratory.springboot.service.BackStage.NormalUserService.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "后台-普通用户管理")
@RestController
@RequestMapping("/bs/api/normaluser")
public class NormalUserController {
    private final NormalUserService normalUserService;

    @Autowired
    public NormalUserController(NormalUserService normalUserService) {
        this.normalUserService = normalUserService;
    }

    @ApiOperation("查询所有学生信息")
    @GetMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryAllNormalUser() {
        return normalUserService.queryAllNormalUser();
    }

    @ApiOperation("获取班级列表")
    @GetMapping("group/list")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryGroupList() {
        return normalUserService.queryGroupList();
    }

    @ApiOperation("通过名字查询学生")
    @GetMapping("name")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryNormalUserByName(String name) {
        return normalUserService.queryNormalUserByName(name);
    }

    @ApiOperation("通过班级查询学生")
    @GetMapping("group")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryNormalUserByGroup(QueryNormalUserByGroupRequest queryNormalUserByGroupRequest) {
        return normalUserService.queryNormalUserByGroup(queryNormalUserByGroupRequest);
    }

    @ApiOperation("修改学生信息")
    @PutMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult updateNormalUser(@RequestBody NormalUserUpdateRequest normalUserUpdateRequest) {
        return normalUserService.updateNormalUserById(normalUserUpdateRequest);
    }

    @DeleteMapping("删除学生信息")
    @PreAuthorize("hasAuthority('Teacher')")
    ResponseResult deleteNormalUserById(@RequestBody NormalUserDeleteRequest normalUserDeleteRequest) {
        return normalUserService.deleteNormalUserById(normalUserDeleteRequest.getId());
    }
}
