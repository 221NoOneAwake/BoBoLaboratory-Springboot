package cn.bobolaboratory.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author WhiteLeaf03
 */
@Configuration
@Data
@PropertySource(value = "classpath:config.yml", factory = PropertySourceFactoryImpl.class)
public class GlobalConfig {
    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;
}
