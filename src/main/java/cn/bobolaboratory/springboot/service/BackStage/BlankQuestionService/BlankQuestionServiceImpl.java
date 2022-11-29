package cn.bobolaboratory.springboot.service.BackStage.BlankQuestionService;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.mapper.BlankQuestionMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WhiteLeaf03
 */
@Service
public class BlankQuestionServiceImpl implements BlankQuestionService {
    private final BlankQuestionMapper blankQuestionMapper;

    @Autowired
    public BlankQuestionServiceImpl(BlankQuestionMapper blankQuestionMapper) {
        this.blankQuestionMapper = blankQuestionMapper;
    }


    /**
     * 新增填空题
     * @param blankQuestion 要添加的题目
     * @return 返回结果
     */
    @Override
    public ResponseResult addBlankQuestion(BlankQuestion blankQuestion) {
        try {
            blankQuestionMapper.addBlankQuestion(blankQuestion);
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
    public ResponseResult queryAllBlankQuestion() {
        return ResponseResult.success(blankQuestionMapper.queryAllBlankQuestion());
    }

    /**
     * 修改题目
     * @param blankQuestion 要修改的内容
     * @return 返回结果
     */
    @Override
    public ResponseResult updateBlankQuestionById(BlankQuestion blankQuestion) {
       try {
           blankQuestionMapper.updateBlankQuestion(blankQuestion);
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
            blankQuestionMapper.deleteQuestionById(id);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
