package cn.bobolaboratory.springboot.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSetAddRequest {
    /**
     * 题库名称
     */
    private String name;

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
    private Integer submitTimes;

    /**
     * 所有提交次数后是否允许查看答案
     */
    private Boolean answer;

    /**
     * 是否开放
     * 0 开放
     * 1 未开放
     */
    private Boolean open;
}
