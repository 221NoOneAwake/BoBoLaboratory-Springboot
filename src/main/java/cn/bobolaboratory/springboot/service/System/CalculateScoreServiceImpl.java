package cn.bobolaboratory.springboot.service.System;

import cn.bobolaboratory.springboot.DTO.AnswerListDTO;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public class CalculateScoreServiceImpl implements CalculateScoreService {
    /**
     * 计算分数并保存记录
     * @param answerListDTO 学生的答案
     * @return 返回结果
     */
    @Override
    public ResponseResult calculateScoreAndSaveRecord(AnswerListDTO answerListDTO) {
        return null;
    }
}
