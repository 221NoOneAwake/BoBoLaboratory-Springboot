package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.service.BackStage.ChoiceQuestionService.ChoiceQuestionService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/choiceQuestion")
public class ChoiceQuestionController {
    private final ChoiceQuestionService choiceQuestionService;

    @Autowired
    public ChoiceQuestionController(ChoiceQuestionService choiceQuestionService) {
        this.choiceQuestionService = choiceQuestionService;
    }

    @Setter
    static class ChoiceQuestionData {
        Long id;
    }

    @PostMapping("")
    public ResponseResult addChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.addChoiceQuestion(choiceQuestion);
    }

    @GetMapping("")
    public ResponseResult queryAllChoiceQuestion() {
        return choiceQuestionService.queryAllChoiceQuestion();
    }

    @PutMapping("")
    public ResponseResult updateQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.updateChoiceQuestion(choiceQuestion);
    }

    @DeleteMapping("")
    public ResponseResult deleteQuestion(@RequestBody ChoiceQuestionData choiceQuestionData) {
        return choiceQuestionService.deleteQuestionById(choiceQuestionData.id);
    }
}