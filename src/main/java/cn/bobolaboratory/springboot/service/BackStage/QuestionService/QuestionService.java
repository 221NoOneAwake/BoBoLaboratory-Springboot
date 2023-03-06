package cn.bobolaboratory.springboot.service.BackStage.QuestionService;

import cn.bobolaboratory.springboot.dto.QuestionAddRequest;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface QuestionService {
    /**
     * 添加单道题目
     * @param questionAddRequest 要添加的题目
     * @return 返回结果
     */
    ResponseResult addSingleQuestion(QuestionAddRequest questionAddRequest);

    /**
     * 管理员获取题目详情
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 答案 分值
     */
    ResponseResult queryQuestionByQuestionSetIdFromBackEnd(Long questionSetId);

    /**
     * 修改题目信息
     * @param question 要修改的题目的信息
     * @return 返回结果
     */
    ResponseResult updateQuestionByQuestionId(Question question);
}
