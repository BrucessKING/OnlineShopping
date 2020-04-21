package top.bigking.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import top.bigking.entity.ResponseData;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;
import java.util.List;
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
    @GetMapping("users/{pageNum}/{pageSize}")
    public ResponseData<Map, Map> getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return userService.queryAllUsers(pageNum, pageSize);

    }

}
