package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.service.FrontDesk.QuestionWarehouse.QuestionWarehouseService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/fd/api/questionWarehouse")
public class QuestionWarehouseController {
    private final QuestionWarehouseService questionWarehouseService;

    @Autowired
    public QuestionWarehouseController(QuestionWarehouseService questionWarehouseService) {
        this.questionWarehouseService = questionWarehouseService;
    }

    @Setter
    static class QuestionWarehouseDTO {
        Long id;
    }

    @GetMapping("")
    public ResponseResult queryAllOpenQuestionWarehouse() {
        return questionWarehouseService.queryAllOpenQuestionWarehouse();
    }

    @GetMapping("")
    public ResponseResult queryQuestionFromQuestionWarehouseById(QuestionWarehouseDTO questionWarehouseDTO) {
        return questionWarehouseService.queryQuestionFromQuestionWarehouseById(questionWarehouseDTO.id);
    }
}
