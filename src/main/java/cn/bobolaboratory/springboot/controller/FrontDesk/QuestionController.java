package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.dto.AnswerListPostRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetGetRequest;
import cn.bobolaboratory.springboot.service.FrontDesk.QuestionService.QuestionService;
import cn.bobolaboratory.springboot.service.FrontDesk.QuestionSetService.QuestionSetService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "前台-题目相关")
@RestController
@RequestMapping("/fd/api")
public class QuestionController {
    private final QuestionSetService questionSetService;
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionSetService questionSetService, QuestionService questionService) {
        this.questionSetService = questionSetService;
        this.questionService = questionService;
    }

    /**
     * 查询所有已开放题目集
     * @return 返回查询结果
     */
    @GetMapping("/questionSet/open")
    public ResponseResult queryOpenQuestionSet() {
        return questionSetService.queryOpenQuestionSet();
    }

    /**
     * 学生获取试卷
     * @param questionSetGetRequest 包含题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 分值
     */
    @GetMapping("/question")
    public ResponseResult queryQuestionByQuestionSetIdFromFrontEnd(QuestionSetGetRequest questionSetGetRequest) {
        return questionService.queryQuestionByQuestionSetIdFromFrontEnd(questionSetGetRequest.getQuestionSetId());
    }

    /**
     * 提交答案
     * @param answerListPostRequest 包含 题集id 和 答案详情 答题详情包括 题目id 答案 选择题为A B C D 判断题为true / false 类型皆为字符串
     */
    @PostMapping("/question")
    public ResponseResult submitAnswer(@RequestBody AnswerListPostRequest answerListPostRequest) {
        return questionService.submitAnswerAndCalculateScore(answerListPostRequest);
    }
}
