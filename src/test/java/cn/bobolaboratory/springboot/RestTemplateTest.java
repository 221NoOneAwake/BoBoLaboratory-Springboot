package cn.bobolaboratory.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        Map<String, Object> map = new HashMap<>();
        map.put("username", "root");
        map.put("password", "yidianshanxin.0");
        ResponseEntity<Object> forEntity = restTemplate.postForEntity("https://www.yidianshanxin.cn/bs/api/login", map, Object.class);
        System.out.println("响应内容为:" + forEntity.getBody());

    }

    @Test
    public void testIntger2Int() {
        Integer a = null;
        if (Objects.isNull(a)) {
            System.out.println(0);
        } else {
            System.out.println(a.intValue());
        }
    }
}
