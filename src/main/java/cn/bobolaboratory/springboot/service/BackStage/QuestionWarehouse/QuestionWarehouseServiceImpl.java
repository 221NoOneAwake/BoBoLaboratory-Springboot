package cn.bobolaboratory.springboot.service.BackStage.QuestionWarehouse;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.entity.QuestionWarehouse;
import cn.bobolaboratory.springboot.mapper.BlankQuestionMapper;
import cn.bobolaboratory.springboot.mapper.ChoiceQuestionMapper;
import cn.bobolaboratory.springboot.mapper.JudgeQuestionMapper;
import cn.bobolaboratory.springboot.mapper.QuestionWarehouseMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionWarehouseServiceImpl implements QuestionWarehouseService {
    private final QuestionWarehouseMapper questionWarehouseMapper;
    private final ChoiceQuestionMapper choiceQuestionMapper;
    private final BlankQuestionMapper blankQuestionMapper;
    private final JudgeQuestionMapper judgeQuestionMapper;

    @Autowired
    public QuestionWarehouseServiceImpl(QuestionWarehouseMapper questionWarehouseMapper, ChoiceQuestionMapper choiceQuestionMapper, BlankQuestionMapper blankQuestionMapper, JudgeQuestionMapper judgeQuestionMapper) {
        this.questionWarehouseMapper = questionWarehouseMapper;
        this.choiceQuestionMapper = choiceQuestionMapper;
        this.blankQuestionMapper = blankQuestionMapper;
        this.judgeQuestionMapper = judgeQuestionMapper;
    }

    /**
     * 新建题目库并添加题目
     * @param questionWarehouse 要添加的题目库
     * @return 返回结果
     */
    @Override
    public ResponseResult addQuestionWarehouse(QuestionWarehouse questionWarehouse) {
        try {
            questionWarehouseMapper.addQuestionWarehouse(questionWarehouse);
            Long id = (questionWarehouseMapper.queryQuestionWarehouseIdByName(questionWarehouse.getName())).get(0);
            if (questionWarehouse.getChoiceQuestionList().size() != 0) {
                for (ChoiceQuestion choiceQuestion : questionWarehouse.getChoiceQuestionList()) {
                    choiceQuestion.setQuestionId(id);
                    choiceQuestionMapper.addChoiceQuestion(choiceQuestion);
                }
            }
            if (questionWarehouse.getBlankQuestionList().size() != 0) {
                for (BlankQuestion blankQuestion : questionWarehouse.getBlankQuestionList()) {
                    blankQuestion.setQuestionId(id);
                    blankQuestionMapper.addBlankQuestion(blankQuestion);
                }
            }
            if (questionWarehouse.getJudgeQuestionList().size() != 0) {
                for (JudgeQuestion judgeQuestion : questionWarehouse.getJudgeQuestionList()) {
                    judgeQuestion.setQuestionId(id);
                    judgeQuestionMapper.addJudgeQuestion(judgeQuestion);
                }
            }
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 查询所有题目库
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryAllQuestionWarehouse() {
        return ResponseResult.success(questionWarehouseMapper.queryAllQuestionWarehouse());
    }

    /**
     * 开放新的题目库
     * @param id 要开放的题目库
     * @return 返回结果
     */
    @Override
    public ResponseResult openQuestionWarehouseById(Long id) {
        try {
            questionWarehouseMapper.openQuestionWarehouseById(id);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 根据id获取题目库中的题目
     * @param id 题目库id
     * @return 返回结果
     */
    @Override
    public ResponseResult queryQuestionFromQuestionWarehouseById(Long id) {
        try {
            Map<String, Object> questions = new HashMap<>();
            List<BlankQuestion> blankQuestionList = blankQuestionMapper.queryQuestionAndAnswerByQuestionId(id);
            List<ChoiceQuestion> choiceQuestionList = choiceQuestionMapper.queryQuestionAndAnswerByQuestionId(id);
            List<JudgeQuestion> judgeQuestionList = judgeQuestionMapper.queryQuestionAndAnswerByQuestionId(id);
            questions.put("BlankQuestion", blankQuestionList);
            questions.put("ChoiceQuestion", choiceQuestionList);
            questions.put("JudgeQuestion", judgeQuestionList);
            return ResponseResult.success(questions);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 根据id删除题目库
     * @param questionId 题目库id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteQuestionWarehouseAndQuestionById(Long questionId) {
        try {
            List<Long> blankQuestionIdList = blankQuestionMapper.queryIdByQuestionId(questionId);
            List<Long> choiceQuestionIdList = choiceQuestionMapper.queryIdByQuestionId(questionId);
            List<Long> judgeQuestionIdList = judgeQuestionMapper.queryIdByQuestionId(questionId);
            for (Long id : blankQuestionIdList) {
                blankQuestionMapper.deleteQuestionById(id);
            }
            for (Long id : choiceQuestionIdList) {
                choiceQuestionMapper.deleteQuestionById(id);
            }
            for (Long id : judgeQuestionIdList) {
                judgeQuestionMapper.deleteQuestionById(id);
            }
            questionWarehouseMapper.deleteQuestionWarehouseById(questionId);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 更新题目库基本信息
     * @param questionWarehouse 要更新的信息
     * @return 返回结果
     */
    @Override
    public ResponseResult updateQuestionWarehouseInfo(QuestionWarehouse questionWarehouse) {
        try {
            questionWarehouseMapper.updateQuestionWarehouseInfo(questionWarehouse);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
