package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.service.System.CalculateScoreService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/fd/api/question")
public class QuestionController {
    private final CalculateScoreService calculateScoreService;

    @Autowired
    public QuestionController(CalculateScoreService calculateScoreService) {
        this.calculateScoreService = calculateScoreService;
    }

    @PostMapping("/answer")
    public ResponseResult checkAnswer(@RequestBody AnswerListDTO answerListDTO) {
        return calculateScoreService.calculateScoreAndSaveRecord(answerListDTO);
    }
}
