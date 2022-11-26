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
public class ChoiceQuestion {
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
     * 选项1
     */
    private String choice1;

    /**
     * 选项2
     */
    private String choice2;

    /**
     * 选项3
     */
    private String choice3;

    /**
     * 选项4
     */
    private String choice4;

    /**
     * 答案
     */
    private String answer;

    /**
     * 分值
     */
    private String score;

    /**
     * 类型
     */
    private String type = "选择题";
}
