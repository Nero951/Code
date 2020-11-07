package nero.springbootstudy.controller;

import nero.springbootstudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

//当前类型注册实例到容器中，并且指定为web请求的处理类
@Controller
//@RequestMapping可以定义请求相关的配置，如路径、请求方法等
@RequestMapping("/user")
public class UserController {
    @Autowired
//    @Resource
    private Map<Integer,Integer> testMap1;

//    @Autowired
//    private User user1;//变量名要和Bean的名称一致，否则会报错

//    @Autowired
//    @Qualifier("user1")
//    private User user;//变量名和Bean的名不一致的时候，@Autowired要搭配@Qualifier指定的名称

    @Resource(name="user2")
    private User user;


    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
//        Map<String,String> map = new HashMap<>();
//        map.put("Japan","坂本龙一");
//        map.put("China","尊龙");
//        return user1;
        return user;
    }
}
