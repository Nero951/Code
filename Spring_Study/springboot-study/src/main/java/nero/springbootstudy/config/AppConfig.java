package nero.springbootstudy.config;

import nero.springbootstudy.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<Integer,Integer> testMap(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        return map;
    }

    @Bean
    public Map<Integer,String> testMap1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"World");
        return map;
    }

    @Bean
    public User user1(){
        User u = new User();
        u.setAge(19);
        u.setName("卡夫卡");
        u.setScore(100);
        return u;
    }

    @Bean
    public User user2(){
        User u = new User();
        u.setAge(18);
        u.setName("马尔克斯");
        u.setScore(98);
        return u;
    }
}
