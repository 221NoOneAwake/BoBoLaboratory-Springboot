package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.dto.QuestionSetAndQuestionListDto;
import cn.bobolaboratory.springboot.dto.QuestionSetIdDto;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.entity.QuestionSet;
import cn.bobolaboratory.springboot.service.BackStage.QuestionService.QuestionService;
import cn.bobolaboratory.springboot.service.BackStage.QuestionSetService.QuestionSetService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionSetService questionSetService;

    @Autowired
    public QuestionController(QuestionService questionService, QuestionSetService questionSetService) {
        this.questionService = questionService;
        this.questionSetService = questionSetService;
    }

    /**
     * 添加题目集
     */
    @PostMapping("/questionSet")
    public ResponseResult newQuestionSet(@RequestBody QuestionSet questionSet) {
        return questionSetService.newQuestionSet(questionSet);
    }

    /**
     * 添加题目集并添加题目
     */
    @PostMapping("/questionSet/add")
    public ResponseResult addQuestionSet(@RequestBody QuestionSetAndQuestionListDto questionSetAndQuestionListDto) {
        return questionSetService.addQuestionSet(questionSetAndQuestionListDto.getQuestionSet(), questionSetAndQuestionListDto.getQuestionList());
    }

    /**
     * 开放题目集
     * @param questionSetIdDto 包含 questionSetId
     * @return 返回结果
     */
    @PutMapping("/questionSet")
    public ResponseResult openQuestionSet(@RequestBody QuestionSetIdDto questionSetIdDto) {
        return questionSetService.openQuestionSet(questionSetIdDto.getQuestionSetId());
    }

    /**
     * 添加单个题目
     */
    @PostMapping("/question")
    public ResponseResult addSingleQuestion(@RequestBody Question question) {
        return questionService.addSingleQuestion(question);
    }


    /**
     * 管理员获取题目详情
     * @param questionSetIdDto 包含题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 答案 分值
     */
    @GetMapping("/question")
    public ResponseResult queryQuestionByQuestionSetIdFromBackEnd(QuestionSetIdDto questionSetIdDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return questionService.queryQuestionByQuestionSetIdFromBackEnd(questionSetIdDto.getQuestionSetId());
    }

    /**
     * 修改题目信息
     * @param question 要修改的题目的信息
     * @return 返回结果
     */
    @PutMapping("/question")
    public ResponseResult modifyQuestion(@RequestBody Question question) {
        return questionService.updateQuestionByQuestionId(question);
    }
}
