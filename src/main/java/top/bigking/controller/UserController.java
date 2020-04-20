package top.bigking.controller;

import org.springframework.web.bind.annotation.*;
import top.bigking.entity.ResponseData;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;
import java.util.Map;

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
    ResponseData<Map, Map> login(@RequestBody User user){
        return userService.login(user.getUsername(), user.getPassword());
    }

}
