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
public class QuestionSetInfoVo {
    /**
     * 题集id
     */
    private Long questionSetId;

    /**
     * 题目名称
     */
    private String name;

    /**
     * 允许答题次数
     */
    private Integer allowSubmitTimes;

    /**
     * 已答题次数
     */
    private Integer alreadySubmitTimes;

    /**
     * 最高成绩
     * 未答题为 -1 1分为 10
     */
    private Integer maxScore;

    /**
     * 单次答题时间
     */
    private Integer examTime;

    /**
     * 是否允许查看答案
     */
    private Boolean answer;
}
