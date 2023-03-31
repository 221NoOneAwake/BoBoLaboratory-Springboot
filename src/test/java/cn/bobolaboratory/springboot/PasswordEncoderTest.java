package cn.bobolaboratory.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Test
    public void pwdEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.matches("123456", "$2a$10$sR.SaZZasQQCjDBtJvAhee1vkfvFxrAK6F6vSQ.yyoeAaNzv8jbtO"));
    }
}
