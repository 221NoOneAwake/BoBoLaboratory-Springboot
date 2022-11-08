package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.Allot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface AllotMapper {
    /**
     * 添加一项题目分配
     * @param allot 要添加的数据
     */
    void addAllot(Allot allot);

    /**
     * 查询所有分配
     * @return 返回查询结果
     */
    List<Allot> queryAllAllot();
}
