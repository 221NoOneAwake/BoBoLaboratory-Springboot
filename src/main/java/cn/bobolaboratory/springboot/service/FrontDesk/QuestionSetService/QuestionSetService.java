package cn.bobolaboratory.springboot.service.FrontDesk.QuestionSetService;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface QuestionSetService {
    /**
     * 查询所有已开放题目集信息以及答题记录信息
     * @return 返回查询结果
     */
    ResponseResult queryOpenQuestionSet();
}
