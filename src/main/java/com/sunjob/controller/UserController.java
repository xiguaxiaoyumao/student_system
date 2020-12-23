package com.sunjob.controller;

import com.sunjob.pojo.User;
import com.sunjob.service.UserService;
import com.sunjob.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author zht
 * @date 2020/12/16 20:14
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/menu")
    @ResponseBody
    public ResponseCode menu(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return ResponseCode.success().put("depart", user.getDepart());
    }

    @RequestMapping(path = "/login")
    @ResponseBody
    public ResponseCode login(@RequestBody User user, HttpSession session) {
        User retUser = userService.login(user);
        if (retUser != null) {
            session.setAttribute("user", retUser);
            return ResponseCode.success();
        } else {
            return ResponseCode.error();
        }
    }

    @RequestMapping(path = "/logout")
    @ResponseBody
    public ResponseCode logout(HttpSession session) {
        session.invalidate();
        return ResponseCode.success();
    }


    @RequestMapping(path = "/userinfo")
    @ResponseBody
    public ResponseCode userinfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return ResponseCode.success().put("user", user);
    }


    @RequestMapping(path = "/select_all_user")
    @ResponseBody
    public List<User> seletAllUser() {
        List<User> users = userService.selectAllUsers();
        return users;
    }

    @RequestMapping(path = "/select_like_username")
    @ResponseBody
    public ResponseCode selectLikeUsername(@RequestBody User user) {
        List<User> users = userService.selectLikeUsername(user);
        return ResponseCode.success().put("users", users);
    }

    @RequestMapping(path = "/delete_user")
    @ResponseBody
    public ResponseCode deleteUser(@RequestBody User user) {
        int i = userService.deleteUser(user);
        if (i >= 0) {
            return ResponseCode.success();
        } else {
            return ResponseCode.error();
        }
    }


    @RequestMapping(path = "/insert_or_update_user")
    @ResponseBody
    public ResponseCode insertOrUpdateUser(@RequestBody User user) {
        int i = userService.insertOrUpdateUser(user);
        if (i >= 0) {
            return ResponseCode.success();
        } else {
            return ResponseCode.error();
        }
    }
}
