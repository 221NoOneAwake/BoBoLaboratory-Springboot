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
}
