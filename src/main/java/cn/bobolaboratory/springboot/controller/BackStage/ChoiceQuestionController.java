package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.service.BackStage.ChoiceQuestionService.ChoiceQuestionService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
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

    @PostMapping("")
    public ResponseResult addChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.addChoiceQuestion(choiceQuestion);
    }

    @GetMapping("")
    public ResponseResult queryAllChoiceQuestion() {
        return choiceQuestionService.queryAllChoiceQuestion();
    }
}