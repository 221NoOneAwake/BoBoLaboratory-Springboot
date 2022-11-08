package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.Allot;
import cn.bobolaboratory.springboot.service.BackStage.AllotService.AllotService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/allot")
public class AllotController {
    private final AllotService allotService;

    @Autowired
    public AllotController(AllotService allotService) {
        this.allotService = allotService;
    }

    @PostMapping("")
    public ResponseResult addAllot(@RequestBody Allot allot) {
        return allotService.addAllot(allot);
    }

    @GetMapping("")
    public ResponseResult queryAllAllot() {
        return allotService.queryAllAllot();
    }
}