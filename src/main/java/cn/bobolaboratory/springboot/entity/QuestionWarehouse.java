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
public class QuestionWarehouse {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 题库名称
     */
    private String name;

    /**
     * 选择题数量
     */
    private int choice;

    /**
     * 填空题数量
     */
    private int blank;

    /**
     * 判断题数量
     */
    private int judge;

    /**
     * 开始日期时间
     */
    private Long startDate;

    /**
     * 结束日期时间
     */
    private Long endDate;

    /**
     * 单次答题时间
     */
    private Long examTime;

    /**
     * 允许答题次数
     */
    private int times;

    /**
     * 提交后是否允许查看答案
     */
    private byte answer;
}