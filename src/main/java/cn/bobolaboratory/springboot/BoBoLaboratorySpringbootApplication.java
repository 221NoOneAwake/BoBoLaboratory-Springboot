package cn.bobolaboratory.springboot;

import cn.bobolaboratory.springboot.config.BeanNameConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author WhiteLeaf03
 */
@SpringBootApplication
@ComponentScan(nameGenerator = BeanNameConfig.class)
public class BoBoLaboratorySpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoBoLaboratorySpringbootApplication.class, args);
    }
}
