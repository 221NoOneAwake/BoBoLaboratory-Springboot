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
public class Allot {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 题库表外键
     */
    private Long questionId;

    /**
     * 班级
     */
    private String group;
}
