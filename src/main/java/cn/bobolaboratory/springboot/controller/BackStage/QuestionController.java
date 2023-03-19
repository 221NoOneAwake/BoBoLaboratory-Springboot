package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.dto.QuestionAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetAndQuestionListAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetGetRequest;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.entity.QuestionSet;
import cn.bobolaboratory.springboot.service.BackStage.QuestionService.QuestionService;
import cn.bobolaboratory.springboot.service.BackStage.QuestionSetService.QuestionSetService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "后台-题目管理")
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
    @ApiOperation("添加题目集")
    @PostMapping("/questionSet")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult newQuestionSet(@RequestBody QuestionSetAddRequest questionSetAddRequest) {
        return questionSetService.newQuestionSet(questionSetAddRequest);
    }

    /**
     * 添加题目集并添加题目
     */
    @ApiOperation("添加题目集并添加题目")
    @PostMapping("/questionSet/add")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult addQuestionSet(@RequestBody QuestionSetAndQuestionListAddRequest questionSetAndQuestionListAddRequest) {
        return questionSetService.addQuestionSet(questionSetAndQuestionListAddRequest);
    }

    /**
     * 开放题目集
     * @param questionSetGetRequest 包含 questionSetId
     * @return 返回结果
     */
    @ApiOperation("开放题目集")
    @PutMapping("/questionSet")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult openQuestionSet(@RequestBody QuestionSetGetRequest questionSetGetRequest) {
        return questionSetService.openQuestionSet(questionSetGetRequest.getQuestionSetId());
    }

    /**
     * 添加单个题目
     */
    @ApiOperation("添加单个题目")
    @PostMapping("/question")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult addSingleQuestion(@RequestBody QuestionAddRequest questionAddRequest) {
        return questionService.addSingleQuestion(questionAddRequest);
    }


    /**
     * 管理员获取题目详情
     * @param questionSetGetRequest 包含题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 答案 分值
     */
    @ApiOperation("管理员获取题目详情")
    @GetMapping("/question")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult queryQuestionByQuestionSetIdFromBackEnd(QuestionSetGetRequest questionSetGetRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return questionService.queryQuestionByQuestionSetIdFromBackEnd(questionSetGetRequest.getQuestionSetId());
    }

    /**
     * 修改题目信息
     * @param question 要修改的题目的信息
     * @return 返回结果
     */
    @ApiOperation("修改题目信息")
    @PutMapping("/question")
    @PreAuthorize("hasAuthority('Teacher')")
    public ResponseResult modifyQuestion(@RequestBody Question question) {
        return questionService.updateQuestionByQuestionId(question);
    }
}
