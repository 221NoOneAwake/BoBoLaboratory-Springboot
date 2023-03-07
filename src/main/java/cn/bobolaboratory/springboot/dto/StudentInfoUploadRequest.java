package cn.bobolaboratory.springboot.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author WhiteLeaf03
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoUploadRequest {
    /**
     * 上传的班级
     */
    private String group;

    /**
     * 上传的Excel表
     */
    private MultipartFile studentInfoExcel;
}
