package cn.bobolaboratory.springboot.service.FrontDesk.QuestionWarehouse;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionWarehouseServiceImpl implements QuestionWarehouseService {
    private final QuestionWarehouseMapper questionWarehouseMapper;
    private final BlankQuestionMapper blankQuestionMapper;
    private final JudgeQuestionMapper judgeQuestionMapper;
    private final ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    public QuestionWarehouseServiceImpl(QuestionWarehouseMapper questionWarehouseMapper, BlankQuestionMapper blankQuestionMapper, JudgeQuestionMapper judgeQuestionMapper, ChoiceQuestionMapper choiceQuestionMapper) {
        this.questionWarehouseMapper = questionWarehouseMapper;
        this.blankQuestionMapper = blankQuestionMapper;
        this.judgeQuestionMapper = judgeQuestionMapper;
        this.choiceQuestionMapper = choiceQuestionMapper;
    }

    /**
     * 查询已开放题目库
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryAllOpenQuestionWarehouse() {
        try {
            List<QuestionWarehouse> list = questionWarehouseMapper.queryAllOpenQuestionWarehouse();
            return ResponseResult.success(list);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 根据题目库Id获取题目
     * @param id 题目库Id
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryQuestionFromQuestionWarehouseById(Long id) {
        try {
            Map<String, Object> questions = new HashMap<>();
            List<BlankQuestion> blankQuestionList = blankQuestionMapper.queryIdAndQuestionByQuestionId(id);
            List<ChoiceQuestion> choiceQuestionList = choiceQuestionMapper.queryIdAndQuestionByQuestionId(id);
            List<JudgeQuestion> judgeQuestionList = judgeQuestionMapper.queryIdAndQuestionByQuestionId(id);
            questions.put("BlankQuestion", blankQuestionList);
            questions.put("ChoiceQuestion", choiceQuestionList);
            questions.put("JudgeQuestion", judgeQuestionList);
            return ResponseResult.success(questions);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
