package nero.springbootstudy.controller;

import nero.springbootstudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/m")
    public String m(){
         return "/main.html";//问题：这里是转发还是重定向？
    }
    @RequestMapping("/l1")
    public String l1(){
        //返回路径，不带/，以当前请求路径为相对位置，查找同一级资源；
        // 但是如果返回路径，带/，会去掉这个当前路径，以项目的部署路径为相对位置
        //return "forward:login";//以当前请求路径/user/l1为相对位置 ,转发到/user同一级查找资源路径
        //return "forward:/login";//去掉当前请求路径/user/l1，以项目路径查找/login
        return "forward:/user/login";//
    }
    @RequestMapping("/l2")
    public String l2(){
        return "redirect:/user/login";
    }

    @RequestMapping("/testMap/{key}")//路径中使用变量占位符
    @ResponseBody
    //url为rest风格的请求
    public Object test1(@PathVariable("key") Integer k){//如果类型不匹配，抛出异常
        System.out.println("===========" +testMap1.get(k));
        return testMap1;
    }

    @RequestMapping(value = "/test2",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    //可以匹配url中的参数，请求体k1=v1&k2=v2格式的数据
    public Object test2(@RequestParam("k1") String ke, //完全的写法
                        @RequestParam String k2,//省略变量名的写法，默认以变量名为key查找请求数据
                        String k3 //最省略的做法，默认就是@RequestParam注解
                        ){
        System.out.println("=========" +ke+ "=====" +k2 +"," +k3);
//        System.out.println("===========" +testMap1.get(k2));
        return testMap1;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user){//请求数据自动映射到参数类型的属性中
        System.out.println(user);
        return testMap1;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(){
        return null;//响应体为空，响应状态码200
    }
    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(){

        return "OK";//返回字符串，响应体没有返回成json格式，而是字符串内容
                    //响应格式不再是application/json，而是text/plain
    }

    @RequestMapping("/test6")
    @ResponseBody
    //Http请求是基于servlet的，Spring已经生成了request和response对象，可以直接在传入参数中使用
    //Spring自动将对象注入到参数
    public Object test6(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("============" +req.getParameter("username")+"===="+req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    //解析请求数据类型为application/json时，解析请求体中的json字符串为java对象
    public Object test7(@RequestBody User user){
        System.out.println("====="+ user);
        return null;
    }
}
