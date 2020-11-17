package nero.service;

import nero.exception.ClientException;
import nero.mapper.UserMapper;
import nero.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
//        User exits = userMapper.login(user);
//        if(exits == null)
//            throw new ClientException("user001", "用户名密码校验失败！");
        User query = new User();
        query.setUsername(user.getUsername());
        User exits = userMapper.login(query);
        if(exits == null)
            throw new ClientException("user001", "用户不存在！");
        if(!exits.getPassword().equals(user.getPassword()))
            throw new ClientException("user002","用户名密码校验失败！");
        return exits;

    }
}
