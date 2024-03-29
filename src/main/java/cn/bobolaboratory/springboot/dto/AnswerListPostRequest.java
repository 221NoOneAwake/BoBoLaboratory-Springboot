package cn.bobolaboratory.springboot.dto;

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
public class AnswerListPostRequest {
    private Long questionSetId;
    List<Answer> answerList;
}
