package cn.bobolaboratory.springboot.service.BackStage.QuestionSetService;

import cn.bobolaboratory.springboot.dto.QuestionSetAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetAndQuestionListAddRequest;
import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.entity.QuestionSet;
import cn.bobolaboratory.springboot.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
public interface QuestionSetService {
    /**
     * 添加题目集
     * @param questionSetAddRequest 要添加的题目集
     * @return 返回结果
     */
    ResponseResult newQuestionSet(QuestionSetAddRequest questionSetAddRequest);

    /**
     * 新增题目集并添加题目
     * @param questionSetAndQuestionListAddRequest 要添加的题目集和要添加的题目
     * @return 返回结果
     */
    ResponseResult addQuestionSet(QuestionSetAndQuestionListAddRequest questionSetAndQuestionListAddRequest);


    /**
     * 查询所有题目集
     * @return 返回查询结果
     */
    ResponseResult queryAllQuestionSet();

    /**
     * 查询所有已开放题目集
     * @return 返回查询结果
     */
    ResponseResult queryOpenQuestionSet();

    /**
     * 根据题集id开放题集
     * @param questionSetId 要开放的题集的id
     * @return 返回结果
     */
    ResponseResult openQuestionSet(Long questionSetId);
}
