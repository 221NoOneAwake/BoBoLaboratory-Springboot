package cn.bobolaboratory.springboot.service.FrontDesk.Record;

import cn.bobolaboratory.springboot.entity.Record;
import cn.bobolaboratory.springboot.mapper.RecordMapper;
import cn.bobolaboratory.springboot.security.AuthNormalUser;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Service
public class RecordServiceImpl implements RecordService {
    private final RecordMapper recordMapper;

    @Autowired
    public RecordServiceImpl(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    /**
     * 用户查询答题记录
     * @return 返回查询结果
     */
    @Override
    public ResponseResult queryRecordByUserId() {
        AuthNormalUser user = (AuthNormalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Record> list = recordMapper.queryRecordByUserId(user.getNormalUser().getId());
            return ResponseResult.success(list);
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
