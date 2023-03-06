package cn.bobolaboratory.springboot.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUserUpdateRequest {
    /**
     * 主键
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
