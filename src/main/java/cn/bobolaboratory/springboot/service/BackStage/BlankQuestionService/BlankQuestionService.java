package cn.bobolaboratory.springboot.service.BackStage.BlankQuestionService;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface BlankQuestionService {
    /**
     * 新增填空题
     * @param blankQuestion 要添加的题目
     * @return 返回结果
     */
    ResponseResult addBlankQuestion(BlankQuestion blankQuestion);

    /**
     * 查询所有题目
     * @return 返回结果
     */
    ResponseResult queryAllBlankQuestion();
}
