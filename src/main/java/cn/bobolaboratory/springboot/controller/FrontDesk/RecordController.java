package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.dto.QuestionSetGetRequest;
import cn.bobolaboratory.springboot.service.FrontDesk.Record.RecordService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "前台-答题详情")
@RestController
@RequestMapping("/fd/api/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("")
    public ResponseResult queryRecordByUserId(QuestionSetGetRequest questionSetGetRequest) {
        return recordService.queryRecordByQuestionSetId(questionSetGetRequest.getQuestionSetId());
    }
}
