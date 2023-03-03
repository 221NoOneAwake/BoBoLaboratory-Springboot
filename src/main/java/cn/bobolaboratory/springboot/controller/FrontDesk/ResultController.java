package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.service.FrontDesk.Result.ResultService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "前台-答题记录")
@RestController
@RequestMapping("/fd/api/result")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("")
    public ResponseResult queryAllRecord() {
        return resultService.queryResultByUserId();
    }
}
