package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.utils.ResponseResult;
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


    @PostMapping("/answer")
    public ResponseResult checkAnswer(@RequestBody AnswerListDTO answerListDTO) {
        return null;
    }
}
