package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse.QuestionWarehouseService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/questionWarehouse")
public class QuestionWarehouseController {
    private final QuestionWarehouseService questionWarehouseService;

    @Setter
    static class QuestionWarehouseData {
        Long id;
    }

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
    public ResponseResult openQuestionWarehouseById(@RequestBody QuestionWarehouseData questionWarehouseData) {
        return questionWarehouseService.openQuestionWarehouseById(questionWarehouseData.id);
    }

    @DeleteMapping("")
    public ResponseResult deleteQuestionWarehouseAndQuestionById(@RequestBody QuestionWarehouseData questionWarehouseData) {
        return questionWarehouseService.deleteQuestionWarehouseAndQuestionById(questionWarehouseData.id);
    }

    @GetMapping("")
    public ResponseResult queryQuestionFromQuestionWarehouseById(QuestionWarehouseData questionWarehouseData) {
        return questionWarehouseService.queryQuestionFromQuestionWarehouseById(questionWarehouseData.id);
    }

    @PutMapping
    public ResponseResult updateQuestionWarehouseInfo(@RequestBody QuestionWarehouse questionWarehouse) {
        return questionWarehouseService.updateQuestionWarehouseInfo(questionWarehouse);
    }
}
