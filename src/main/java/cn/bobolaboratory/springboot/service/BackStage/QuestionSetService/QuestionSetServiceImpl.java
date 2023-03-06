package cn.bobolaboratory.springboot.service.BackStage.QuestionSetService;

import cn.bobolaboratory.springboot.dto.QuestionAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetAddRequest;
import cn.bobolaboratory.springboot.dto.QuestionSetAndQuestionListAddRequest;
import cn.bobolaboratory.springboot.vo.QuestionSetInfoVo;
import cn.bobolaboratory.springboot.entity.QuestionSet;
import cn.bobolaboratory.springboot.mapper.QuestionMapper;
import cn.bobolaboratory.springboot.mapper.QuestionSetMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionSetServiceImpl implements QuestionSetService {
    private final QuestionMapper questionMapper;
    private final QuestionSetMapper questionSetMapper;

    @Autowired
    public QuestionSetServiceImpl(QuestionMapper questionMapper, QuestionSetMapper questionSetMapper) {
        this.questionMapper = questionMapper;
        this.questionSetMapper = questionSetMapper;
    }

    /**
     * 新增一个题目集
     * @param questionSetAddRequest 要添加的题目集
     * @return 返回结果
     */
    @Override
    public ResponseResult newQuestionSet(QuestionSetAddRequest questionSetAddRequest) {
        try {
            questionSetMapper.insertQuestionSet(questionSetAddRequest);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }

    /**
     * 新增题目集并添加题目
     * @param questionSetAndQuestionListAddRequest  要添加的题目集和要添加的题目
     * @return 返回结果
     */
    @Override
    public ResponseResult addQuestionSet(QuestionSetAndQuestionListAddRequest questionSetAndQuestionListAddRequest) {
        try {
            questionSetMapper.insertQuestionSet(questionSetAndQuestionListAddRequest.getQuestionSet());
            final Long questionSetId = questionSetMapper.getLastInsertId();
            for (QuestionAddRequest question : questionSetAndQuestionListAddRequest.getQuestionList()) {
                question.setQuestionSetId(questionSetId);
                if ("".equals(question.getChoice1())) {
                    questionMapper.insertJudgeQuestion(question);
                } else {
                    questionMapper.insertChoiceQuestion(question);
                }
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }

    /**
     * 查询所有题目集
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryAllQuestionSet() {
        List<QuestionSet> questionSetList;
        try {
            questionSetList = questionSetMapper.selectAllQuestionSet();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionSetList);
    }

    /**
     * 查询所有已开放题目集
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryOpenQuestionSet() {
        List<QuestionSetInfoVo> questionSetList;
        try {
            questionSetList = questionSetMapper.selectOpenQuestionSetInfo();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionSetList);
    }

    /**
     * 根据题集id开放题集
     * @param questionSetId 要开放的题集的id
     * @return 返回结果
     */
    @Override
    public ResponseResult openQuestionSet(Long questionSetId) {
        try {
            questionSetMapper.openQuestionSet(questionSetId);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }
}
