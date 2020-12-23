package com.sunjob.service;

import com.sunjob.mapper.UserMapper;
import com.sunjob.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zht
 * @date 2020/12/20 10:41
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);
    }

    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public List<User> selectLikeUsername(User user) {
        if (user.getUsername() == null || user.getUsername() == "") {
            return userMapper.selectAllUsers();
        }
        return userMapper.selectLikeUsername(user);
    }

    public int insertOrUpdateUser(User user) {
        List<User> users = userMapper.serlectByid(user);
        int i = 0;
        if (users.size() == 0) {
            i = userMapper.insert(user);
        } else {
            i = userMapper.update(user);
        }
        return i;
    }

    public int deleteUser(User user) {
        return userMapper.delete(user);
    }


}
