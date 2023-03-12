package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.dto.NormalUserDeleteRequest;
import cn.bobolaboratory.springboot.dto.NormalUserUpdateRequest;
import cn.bobolaboratory.springboot.dto.QueryNormalUserByGroupRequest;
import cn.bobolaboratory.springboot.service.BackStage.NormalUserService.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
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

    @GetMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryAllNormalUser() {
        return normalUserService.queryAllNormalUser();
    }

    @GetMapping("group/list")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryGroupList() {
        return normalUserService.queryGroupList();
    }

    @GetMapping("name")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryNormalUserByName(String name) {
        return normalUserService.queryNormalUserByName(name);
    }

    @GetMapping("group")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryNormalUserByGroup(QueryNormalUserByGroupRequest queryNormalUserByGroupRequest) {
        return normalUserService.queryNormalUserByGroup(queryNormalUserByGroupRequest);
    }

    @PutMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult updateNormalUser(@RequestBody NormalUserUpdateRequest normalUserUpdateRequest) {
        return normalUserService.updateNormalUserById(normalUserUpdateRequest);
    }

    @DeleteMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    ResponseResult deleteNormalUserById(@RequestBody NormalUserDeleteRequest normalUserDeleteRequest) {
        return normalUserService.deleteNormalUserById(normalUserDeleteRequest.getId());
    }
}
