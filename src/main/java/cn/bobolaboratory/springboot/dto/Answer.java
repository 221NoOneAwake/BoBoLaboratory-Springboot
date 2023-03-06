package cn.bobolaboratory.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    /**
     * 题目的id
     */
    Long id;

    /**
     * 学生填的答案
     */
    String answer;
}
