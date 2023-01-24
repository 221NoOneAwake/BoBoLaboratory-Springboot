package cn.bobolaboratory.springboot.service.BackStage.QuestionSetService;

import cn.bobolaboratory.springboot.dto.QuestionSetInfoDto;
import cn.bobolaboratory.springboot.entity.Question;
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
     * @param questionSet 要添加的题目集
     * @return 返回结果
     */
    @Override
    public ResponseResult newQuestionSet(QuestionSet questionSet) {
        try {
            questionSetMapper.insertQuestionSet(questionSet);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success();
    }

    /**
     * 新增题目集并添加题目
     * @param questionSet  要添加的题目集
     * @param questionList 要添加的题目
     * @return 返回结果
     */
    @Override
    public ResponseResult addQuestionSet(QuestionSet questionSet, List<Question> questionList) {
        try {
            questionSetMapper.insertQuestionSet(questionSet);
            final Long questionSetId = questionSetMapper.getLastInsertId();
            for (Question question : questionList) {
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
        List<QuestionSetInfoDto> questionSetList;
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