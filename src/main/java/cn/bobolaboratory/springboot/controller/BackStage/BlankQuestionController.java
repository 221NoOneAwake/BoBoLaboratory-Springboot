package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.service.BackStage.BlankQuestionService.BlankQuestionService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/blankQuestion")
public class BlankQuestionController {
    private final BlankQuestionService blankQuestionService;

    @Autowired
    public BlankQuestionController(BlankQuestionService blankQuestionService) {
        this.blankQuestionService = blankQuestionService;
    }

    @Setter
    static class BlankQuestionData {
        Long id;
    }

    @PostMapping("")
    public ResponseResult addBlankQuestion(@RequestBody BlankQuestion blankQuestion) {
        return blankQuestionService.addBlankQuestion(blankQuestion);
    }

    @GetMapping("")
    public ResponseResult queryAllBlankQuestion() {
        return blankQuestionService.queryAllBlankQuestion();
    }

    @PutMapping("")
    public ResponseResult updateQuestion(@RequestBody BlankQuestion blankQuestion) {
        return blankQuestionService.updateBlankQuestion(blankQuestion);
    }

    @DeleteMapping("")
    public ResponseResult deleteQuestion(@RequestBody BlankQuestionData blankQuestionData) {
        return blankQuestionService.deleteQuestionById(blankQuestionData.id);
    }
}