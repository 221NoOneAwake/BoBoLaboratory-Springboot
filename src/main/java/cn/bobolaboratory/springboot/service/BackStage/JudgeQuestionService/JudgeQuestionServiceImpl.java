package cn.bobolaboratory.springboot.service.BackStage.JudgeQuestionService;

import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import cn.bobolaboratory.springboot.mapper.JudgeQuestionMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {
    private final JudgeQuestionMapper judgeQuestionMapper;

    @Autowired
    public JudgeQuestionServiceImpl(JudgeQuestionMapper judgeQuestionMapper) {
        this.judgeQuestionMapper = judgeQuestionMapper;
    }

    /**
     * 新增判断题题
     * @param judgeQuestion 要添加的题目
     */
    @Override
    public ResponseResult addJudgeQuestion(JudgeQuestion judgeQuestion) {
        try {
            judgeQuestionMapper.addJudgeQuestion(judgeQuestion);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 查询所有题目
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryAllJudgeQuestion() {
        return ResponseResult.success(judgeQuestionMapper.queryAllJudgeQuestion());
    }

    /**
     * 修改题目
     * @param judgeQuestion 要修改的内容
     * @return 返回结果
     */
    @Override
    public ResponseResult updateJudgeQuestionById(JudgeQuestion judgeQuestion) {
        try {
            judgeQuestionMapper.updateJudgeQuestionById(judgeQuestion);
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
            judgeQuestionMapper.deleteQuestionById(id);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
