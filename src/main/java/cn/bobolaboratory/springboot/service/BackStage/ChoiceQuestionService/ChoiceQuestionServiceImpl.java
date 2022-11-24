package cn.bobolaboratory.springboot.service.BackStage.ChoiceQuestionService;

import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.mapper.ChoiceQuestionMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {
    private final ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    public ChoiceQuestionServiceImpl(ChoiceQuestionMapper choiceQuestionMapper) {
        this.choiceQuestionMapper = choiceQuestionMapper;
    }

    /**
     * 新增选择题
     * @param choiceQuestion 要添加的题目
     * @return 返回结果
     */
    @Override
    public ResponseResult addChoiceQuestion(ChoiceQuestion choiceQuestion) {
        try {
            choiceQuestionMapper.addChoiceQuestion(choiceQuestion);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 查询所有题目
     * @return 返回结果
     */
    @Override
    public ResponseResult queryAllChoiceQuestion() {
        return ResponseResult.success(choiceQuestionMapper.queryAllChoiceQuestion());
    }

    /**
     * 修改题目
     * @param choiceQuestion 要修改的内容
     * @return 返回结果
     */
    @Override
    public ResponseResult updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        try {
            choiceQuestionMapper.updateChoiceQuestion(choiceQuestion);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 删除题目
     * @param id 要删除的题目的id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteQuestionById(Long id) {
        try {
            choiceQuestionMapper.deleteQuestionById(id);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
