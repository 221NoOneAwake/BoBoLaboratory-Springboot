package cn.bobolaboratory.springboot.service.BackStage.ResultService;

import cn.bobolaboratory.springboot.entity.Result;
import cn.bobolaboratory.springboot.mapper.QuestionSetMapper;
import cn.bobolaboratory.springboot.mapper.ResultMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import cn.bobolaboratory.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class ResultServiceImpl implements ResultService {
    private final ResultMapper resultMapper;
    private final QuestionSetMapper questionSetMapper;

    @Autowired
    public ResultServiceImpl(ResultMapper resultMapper, QuestionSetMapper questionSetMapper) {
        this.resultMapper = resultMapper;
        this.questionSetMapper = questionSetMapper;
    }

    /**
     * 根据用户id获取所有相关答题记录
     * @param id 用户id
     * @return 返回该用户的所有答题记录
     */
    @Override
    public ResponseResult queryResultByUserId(Long id) {
        try {
            List<ResultVo> resultVoList = new ArrayList<>();
            List<Result> resultList = resultMapper.selectResultByUserId(id);
            for (Result result : resultList) {
                resultVoList.add(new ResultVo(result, questionSetMapper.queryNameById(result.getQuestionSetId())));
            }
            return ResponseResult.success(resultVoList);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
