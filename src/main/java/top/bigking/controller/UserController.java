package top.bigking.controller;

import org.springframework.web.bind.annotation.*;
import top.bigking.annotation.AccessLimit;
import top.bigking.entity.ResponseData;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author ABKing
 * @since 2020/4/14 下午4:48
 **/
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
//    @PostMapping("login")
//    ResponseData<Map, Map> login(@RequestBody User user){
//        return userService.login(user.getUsername(), user.getPassword());
//    }
    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @GetMapping("users/{pageNum}/{pageSize}")
    public ResponseData<Map, Map> getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return userService.queryAllUsers(pageNum, pageSize);

    }

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @PostMapping("users")
    public ResponseData<Map, Map> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @PutMapping("users/{uId}/state/{type}")
    public ResponseData<Map, Map> updateUserState(@PathVariable Integer uId, @PathVariable Boolean type){
        User user = new User();
        user.setUserId(uId);
        return userService.updateUserState(user, type ? "是" : "否");
    }

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @GetMapping("users/{id}")
    public ResponseData<Map, Map> queryById(@PathVariable Integer id){
        return userService.queryById(id);
    }

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @PutMapping("users/{id}")
    public ResponseData<Map, Map> updateUser(@PathVariable Integer id, @RequestBody User user){
        user.setUserId(id);
        return userService.updateUser(user);
    }

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @DeleteMapping("users/{id}")
    public ResponseData<Map, Map> deleteById(@PathVariable Integer id){
        return userService.deleteById(id);
    }
    /**
     * 分配用户角色
     */
    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @PutMapping("users/{id}/role")
    public ResponseData<Map, Map> assignUserRole(@PathVariable Integer id, @RequestBody User user){
        Integer rid = user.getRoleId();
        System.out.println(rid);
        return userService.assignUserRole(id, rid);
    }
}
