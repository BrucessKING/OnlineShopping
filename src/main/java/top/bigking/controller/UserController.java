package top.bigking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;

/**
 * @Author ABKing
 * @since 2020/4/14 下午4:48
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("login")
    User login(@RequestBody User user){
        return userService.login(user.getUsername(), user.getPassword());

    }
}
