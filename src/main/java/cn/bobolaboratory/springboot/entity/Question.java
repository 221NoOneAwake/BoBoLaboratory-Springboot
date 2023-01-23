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
public class Question {
    /**
     * 主键
     */
    Long id;

    /**
     * 题目集主键
     */
    Long questionSetId;

    /**
     * 题目
     */
    String title;

    /**
     * 题目类型
     * 0: 判断题
     * 1: 选择题
     */
    Short type;

    /**
     * 选项1
     */
    String choice1;

    /**
     * 选项2
     */
    String choice2;

    /**
     * 选项3
     */
    String choice3;

    /**
     * 选项4
     */
    String choice4;

    /**
     * 答案
     */
    String answer;

    /**
     * 分数
     * 比例1:10
     * 1分对应10
     */
    Integer score;
}
