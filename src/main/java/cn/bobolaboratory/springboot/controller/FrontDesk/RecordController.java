package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.service.FrontDesk.Record.RecordService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/fd/api/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("")
    public ResponseResult queryRecordByUserId() {
        return recordService.queryRecordByUserId();
    }
}
