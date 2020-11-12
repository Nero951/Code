package nero.springbootstudy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import nero.springbootstudy.config.interceptor.LoginInterceptor;
import nero.springbootstudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer {//web框架，执行初始化工作的时候，会调用接口方法
    //注意：/**表示模糊匹配拦截，
    // 静态资源也会被拦截

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 添加web配置，添加拦截器（根据路径进行拦截）
     * /*：代表一级的路径，如：/user/*，可以匹配到/user/abc,不能匹配到/user/abc/1
     * /**：代表多级路径，都能匹配到
     * 静态资源也会被拦截到
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //实现用户会话管理的功能
        registry.addInterceptor(new LoginInterceptor(objectMapper))//链式方法设计：当前类型方法的返回值还是返回值
                .addPathPatterns("/user/**")//添加要拦截的路径
                .excludePathPatterns("/user/login");//要排除的路径
    }

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
        u.setUsername("abc");
        u.setPassword("123");
        return u;
    }

    @Bean
    public User user2(){
        User u = new User();
        u.setUsername("efg");
        u.setPassword("1234");
        return u;
    }
}
