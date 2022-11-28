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
     * 题目的id
     */
    private Long questionId;

    /**
     * 用户的openid
     */
    private String openId;

    /**
     * 题目类型
     */
    private String type;

    /**
     * 答题时间
     */
    private Long date;

    /**
     * 答题的次数
     */
    private Integer times;

    /**
     * 答案
     */
    private String answer;

    /**
     * 是否正确
     */
    private byte result;

    /**
     * 得分 * 10
     */
    private int score;

    public Record(Long questionId, String openId, String type, Long date, Integer times, String answer, byte result, int score) {
        this.questionId = questionId;
        this.openId = openId;
        this.type = type;
        this.date = date;
        this.times = times;
        this.answer = answer;
        this.result = result;
        this.score = score;
    }

    public Record(Long questionId, String openId, String type) {
        this.questionId = questionId;
        this.openId = openId;
        this.type = type;
    }
}
