package cn.bobolaboratory.springboot.service.FrontDesk.Result;

import cn.bobolaboratory.springboot.entity.Result;
import cn.bobolaboratory.springboot.mapper.ResultMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import cn.bobolaboratory.springboot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author WhiteLeaf03
 */
@Service
public class ResultServiceImpl implements ResultService {
    private final ResultMapper resultMapper;

    @Autowired
    public ResultServiceImpl(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    /**
     * 根据用户id获取所有相关答题记录
     * @return 返回该用户的所有答题记录
     */
    @Override
    public ResponseResult queryResultByUserId() {
        Long userId = UserUtil.getNormalUserId();
        try {
            return ResponseResult.success(resultMapper.selectResultByUserId(userId));
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 根据用户id和题集id获取已答题次数和最高成绩
     * @param questionSetId 题集id
     * @return 返回用户在题集的已答题次数
     */
    @Override
    public ResponseResult queryResidueSubmitTimesByUserIdAndQuestionSetId(Long questionSetId) {
        Long userId = UserUtil.getNormalUserId();
        Map<String, Object> map = new HashMap<>();
        Integer submitTimes = 0;
        Integer maxScore = -1;
        try {
            Result result = resultMapper.countSubmitTimesByUserIdAndQuestionSetId(userId, questionSetId);
            if (!Objects.isNull(result)) {
                submitTimes = result.getSubmitTimes();
                maxScore = result.getMaxScore();
            }
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
        map.put("submitTimes", submitTimes);
        map.put("maxScore", maxScore);
        return ResponseResult.success(map);
    }
}
