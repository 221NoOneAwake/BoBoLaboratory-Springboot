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
     * 答案
     */
    private String answer;


    /**
     * 类型
     */
    private String type = "判断题";
}
