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
    @PostMapping("users")
    public ResponseData<Map, Map> addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("users/{uId}/state/{type}")
    public ResponseData<Map, Map> updateUser(@PathVariable Integer uId, @PathVariable Boolean type){
        User user = new User();
        user.setUserId(uId);
        return userService.updateUserState(user, type ? "是" : "否");
    }
    @GetMapping("users/{id}")
    public ResponseData<Map, Map> queryById(@PathVariable Integer id){
        return userService.queryById(id);
    }

}
