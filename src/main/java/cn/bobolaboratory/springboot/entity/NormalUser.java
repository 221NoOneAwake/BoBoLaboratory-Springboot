package cn.bobolaboratory.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 微信openid
     */
    private String openId;

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

    public NormalUser(String openId) {
        this.openId = openId;
    }
}
