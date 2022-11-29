package cn.bobolaboratory.springboot.DTO;

import cn.bobolaboratory.springboot.entity.BlankQuestion;
import cn.bobolaboratory.springboot.entity.ChoiceQuestion;
import cn.bobolaboratory.springboot.entity.JudgeQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerListDTO {
    /**
     * 包含填空题id和答案
     */
    private List<BlankQuestion> blankQuestionList;

    /**
     * 包含选择题id和答案
     */
    private List<ChoiceQuestion> choiceQuestionList;

    /**
     * 包含判断题id和答案
     */
    private List<JudgeQuestion> judgeQuestionList;

    /**
     * 答题日期时间戳
     */
    private Long date;

    /**
     * 答题次数
     */
    private Integer times;

    public AnswerListDTO(List<BlankQuestion> blankQuestionList, List<ChoiceQuestion> choiceQuestionList, List<JudgeQuestion> judgeQuestionList, Long date) {
        this.blankQuestionList = blankQuestionList;
        this.choiceQuestionList = choiceQuestionList;
        this.judgeQuestionList = judgeQuestionList;
        this.date = date;
    }
}
