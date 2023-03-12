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
public class QueryNormalUserByGroupRequest {
    /**
     * 班级
     */
    String group;
}
