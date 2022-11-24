package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse.QuestionWarehouseService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/questionWarehouse")
public class QuestionWarehouseController {
    private final QuestionWarehouseService questionWarehouseService;

    @Autowired
    public QuestionWarehouseController(QuestionWarehouseService questionWarehouseService) {
        this.questionWarehouseService = questionWarehouseService;
    }

    @PostMapping("")
    public ResponseResult addQuestionWarehouse(@RequestBody QuestionWarehouse questionWarehouse) {
        return questionWarehouseService.addQuestionWarehouse(questionWarehouse);
    }

    @GetMapping("/all")
    public ResponseResult queryAllQuestionWarehouse() {
        return questionWarehouseService.queryAllQuestionWarehouse();
    }

    @PutMapping("/open")
    public ResponseResult openQuestionWarehouseById(@RequestBody Long id) {
        return questionWarehouseService.openQuestionWarehouseById(id);
    }

    @DeleteMapping("")
    public ResponseResult deleteQuestionWarehouseAndQuestionById(@RequestBody Long id) {
        return questionWarehouseService.deleteQuestionWarehouseAndQuestionById(id);
    }

    @GetMapping("")
    public ResponseResult queryQuestionFromQuestionWarehouseById(Long id) {
        return questionWarehouseService.queryQuestionFromQuestionWarehouseById(id);
    }

    @PutMapping
    public ResponseResult updateQuestionWarehouseInfo(@RequestBody QuestionWarehouse questionWarehouse) {
        return questionWarehouseService.updateQuestionWarehouseInfo(questionWarehouse);
    }
}
