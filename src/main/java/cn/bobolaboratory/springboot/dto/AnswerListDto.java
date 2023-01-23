package cn.bobolaboratory.springboot.dto;

import cn.bobolaboratory.springboot.entity.Question;
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
public class AnswerListDto {
    private Long questionSetId;
    List<Question> questionList;
}
