package cn.bobolaboratory.springboot.service.FrontDesk.QuestionSetService;

import cn.bobolaboratory.springboot.vo.QuestionSetInfoVo;
import cn.bobolaboratory.springboot.entity.Result;
import cn.bobolaboratory.springboot.mapper.QuestionSetMapper;
import cn.bobolaboratory.springboot.mapper.ResultMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import cn.bobolaboratory.springboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class QuestionSetServiceImpl implements QuestionSetService {
    private final QuestionSetMapper questionSetMapper;
    private final ResultMapper resultMapper;

    @Autowired
    public QuestionSetServiceImpl(QuestionSetMapper questionSetMapper, ResultMapper resultMapper) {
        this.questionSetMapper = questionSetMapper;
        this.resultMapper = resultMapper;
    }

    /**
     * 查询所有已开放题目集信息以及答题记录信息
     * @return 返回 开放题集信息 包含
     */
    @Override
    public ResponseResult queryOpenQuestionSet() {
        Long userId = UserUtil.getNormalUserId();
        List<QuestionSetInfoVo> questionSetInfoVoList;
        try {
            //questionSetId, allowSubmitTimes, examTime, answer
            questionSetInfoVoList = questionSetMapper.selectOpenQuestionSetInfo();
            Result result;
            for (QuestionSetInfoVo questionSetInfoVo : questionSetInfoVoList) {
                result = resultMapper.countSubmitTimesByUserIdAndQuestionSetId(userId, questionSetInfoVo.getQuestionSetId());
                questionSetInfoVo.setAlreadySubmitTimes(result.getSubmitTimes());
                if (result.getMaxScore() == null) {
                    questionSetInfoVo.setMaxScore(-1);
                } else {
                    questionSetInfoVo.setMaxScore(result.getMaxScore());
                }
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionSetInfoVoList);
    }
}
