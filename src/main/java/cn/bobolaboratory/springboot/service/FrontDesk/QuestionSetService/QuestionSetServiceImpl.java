package cn.bobolaboratory.springboot.service.FrontDesk.QuestionSetService;

import cn.bobolaboratory.springboot.dto.QuestionSetInfoDto;
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
        List<QuestionSetInfoDto> questionSetInfoDtoList;
        try {
            //questionSetId, allowSubmitTimes, examTime, answer
            questionSetInfoDtoList = questionSetMapper.selectOpenQuestionSetInfo();
            Result result;
            for (QuestionSetInfoDto questionSetInfoDto : questionSetInfoDtoList) {
                result = resultMapper.countSubmitTimesByUserIdAndQuestionSetId(userId, questionSetInfoDto.getQuestionSetId());
                questionSetInfoDto.setAlreadySubmitTimes(result.getSubmitTimes());
                if (result.getMaxScore() == null) {
                    questionSetInfoDto.setMaxScore(-1);
                } else {
                    questionSetInfoDto.setMaxScore(result.getMaxScore());
                }
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        return ResponseResult.success(questionSetInfoDtoList);
    }
}
