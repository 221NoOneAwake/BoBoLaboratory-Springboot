package cn.bobolaboratory.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUserListVo {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 班级
     */
    private String group;

    /**
     * 学号
     */
    private String schoolId;

    /**
     * 性别
     */
    private String sex;
}
