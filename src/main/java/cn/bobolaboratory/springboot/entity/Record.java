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
public class Record {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 题目集id
     */
    private Long questionSetId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 题目类型
     * 0 判断
     * 1 选择
     */
    private Short type;

    /**
     * 答题时间
     */
    private Long submitDate;

    /**
     * 答题的次数
     */
    private Integer submitTimes;

    /**
     * 答案
     */
    private String answer;

    /**
     * 是否正确
     */
    private Boolean result;

    /**
     * 得分 * 10
     */
    private Integer score;

    public Record(Long questionSetId, Long questionId, Long userId, Short type, Long submitDate, Integer submitTimes, String answer, Boolean result, Integer score) {
        this.questionSetId = questionSetId;
        this.questionId = questionId;
        this.userId = userId;
        this.type = type;
        this.submitDate = submitDate;
        this.submitTimes = submitTimes;
        this.answer = answer;
        this.result = result;
        this.score = score;
    }
}
