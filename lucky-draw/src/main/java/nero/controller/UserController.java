package nero.controller;

import nero.model.User;
import nero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;//一定要在类型上加上@Service，注册到容器中
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req){
        User exist = userService.login(user);//exist为数据库查询的用户，如果查询不到，为null
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);
        return null;
    }

}
