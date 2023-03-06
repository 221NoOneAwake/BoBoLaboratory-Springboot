package cn.bobolaboratory.springboot.dto;

import cn.bobolaboratory.springboot.entity.Question;
import cn.bobolaboratory.springboot.entity.QuestionSet;
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
public class QuestionSetAndQuestionListAddRequest {
    QuestionSetAddRequest questionSet;
    List<QuestionAddRequest> questionList;
}
