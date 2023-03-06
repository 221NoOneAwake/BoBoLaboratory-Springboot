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
public class NormalUserLoginRequest {
    /**
     * 临时登录用户凭证
     */
    private String code;
}
