package cn.bobolaboratory.springboot.service.BackStage.JudgeQuestionService;

import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface JudgeQuestionService {
    /**
     * 新增判断题题
     * @param judgeQuestion 要添加的题目
     */
    ResponseResult addJudgeQuestion(JudgeQuestion judgeQuestion);

    /**
     * 查询所有题目
     * @return 返回查询结果
     */
    ResponseResult queryAllJudgeQuestion();
}
