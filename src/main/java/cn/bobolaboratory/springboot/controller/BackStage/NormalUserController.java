package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.service.BackStage.NormalUserService.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bs/api/normaluser")
public class NormalUserController {
    private final NormalUserService normalUserService;

    @Autowired
    public NormalUserController(NormalUserService normalUserService) {
        this.normalUserService = normalUserService;
    }

    @Setter
    static class NormalUserData {
        Long id;
    }

    @GetMapping("")
    public ResponseResult queryAllNormalUser() {
        return normalUserService.queryAllNormalUser();
    }

    @PutMapping("")
    public ResponseResult updateNormalUser(@RequestBody NormalUser normalUser) {
        return normalUserService.updateNormalUserById(normalUser);
    }

    @DeleteMapping("")
    ResponseResult deleteNormalUserById(@RequestBody NormalUserData normalUserData) {
        return normalUserService.deleteNormalUserById(normalUserData.id);
    }
}
