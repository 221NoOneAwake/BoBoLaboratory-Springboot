package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.service.BackStage.NormalUserService.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
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

    @GetMapping("")
    public ResponseResult queryAllNormalUser() {
        return normalUserService.queryAllNormalUser();
    }

    @PutMapping("")
    public ResponseResult updateNormalUser(@RequestBody NormalUser normalUser) {
        return normalUserService.updateNormalUserById(normalUser);
    }

    @DeleteMapping("")
    ResponseResult deleteNormalUserById(Long id) {
        return normalUserService.deleteNormalUserById(id);
    }
}
