package cn.bobolaboratory.springboot.vo;

import cn.bobolaboratory.springboot.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    /**
     * 题集名称
     */
    String name;

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

    public ResultVo(Result result, String name) {
        this.name = name;
        this.maxScore = result.getMaxScore();
        this.totalScore = result.getTotalScore();
        this.submitDate = result.getSubmitDate();
        this.submitTimes = result.getSubmitTimes();
    }
}
