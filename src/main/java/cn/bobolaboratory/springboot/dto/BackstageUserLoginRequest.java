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
public class BackstageUserLoginRequest {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
