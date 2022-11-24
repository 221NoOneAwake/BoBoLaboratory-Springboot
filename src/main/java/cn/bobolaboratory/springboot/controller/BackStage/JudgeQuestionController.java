package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.service.BackStage.JudgeQuestionService.JudgeQuestionService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/judgeQuestion")
public class JudgeQuestionController {
    private final JudgeQuestionService judgeQuestionService;

    @Autowired
    public JudgeQuestionController(JudgeQuestionService judgeQuestionService) {
        this.judgeQuestionService = judgeQuestionService;
    }

    @PostMapping("")
    public ResponseResult addJudgeQuestion(@RequestBody JudgeQuestion judgeQuestion) {
        return judgeQuestionService.addJudgeQuestion(judgeQuestion);
    }

    @GetMapping("")
    public ResponseResult queryAllJudgeQuestion() {
        return judgeQuestionService.queryAllJudgeQuestion();
    }

    @PutMapping("")
    public ResponseResult updateQuestion(@RequestBody JudgeQuestion judgeQuestion) {
        return judgeQuestionService.updateJudgeQuestion(judgeQuestion);
    }

    @DeleteMapping("")
    public ResponseResult deleteQuestion(@RequestBody Long id) {
        return judgeQuestionService.deleteQuestionById(id);
    }
}