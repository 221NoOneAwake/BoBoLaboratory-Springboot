package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.service.BackStage.ResultService.ResultService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "后台-成绩")
@RestController
@RequestMapping("/bs/api/result")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @ApiOperation("根据id查询学生的答题情况")
    @GetMapping("")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryAllRecord(Long id) {
        return resultService.queryResultByUserId(id);
    }
}
