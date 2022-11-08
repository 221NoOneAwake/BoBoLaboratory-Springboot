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
public class JudgeQuestion {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 题库表外键
     */
    private Long questionId;

    /**
     * 题目
     */
    private String question;

    /**
     * 题目
     */
    private String answer;
}
