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
public class Result {
    /**
     * 主键自增
     */
    Long id;

    /**
     * 所答题集的id
     * 题目表外键
     */
    Long questionSetId;

    /**
     * 学生id
     * 非openid
     * 学生表外键
     */
    Long userId;

    /**
     * 最高成绩 无最高成绩则为-1 分数与值为1:10
     */
    Integer maxScore;

    /**
     * 满分
     */
    Integer totalScore;

    /**
     * 提交日期
     * 毫秒时间戳
     */
    Long submitDate;

    /**
     * 已提交次数
     */
    Integer submitTimes;

    public Result(Long questionSetId, Long userId, Integer maxScore, Integer totalScore, Long submitDate, Integer submitTimes) {
        this.questionSetId = questionSetId;
        this.userId = userId;
        this.maxScore = maxScore;
        this.totalScore = totalScore;
        this.submitDate = submitDate;
        this.submitTimes = submitTimes;
    }

    public Result(Long questionSetId, Long userId, Integer maxScore, Long submitDate, Integer submitTimes) {
        this.questionSetId = questionSetId;
        this.userId = userId;
        this.maxScore = maxScore;
        this.submitDate = submitDate;
        this.submitTimes = submitTimes;
    }
}
