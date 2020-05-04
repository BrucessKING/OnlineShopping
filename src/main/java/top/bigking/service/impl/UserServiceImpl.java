package top.bigking.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.bigking.dao.UserDao;
import top.bigking.entity.ResponseData;
import top.bigking.entity.User;
import top.bigking.service.UserService;
import top.bigking.util.PasswordUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ABKing
 * @since 2020/4/14 下午4:53
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public ResponseData<Map, Map> login(String username, String password) {
        User user1 = userDao.login(username);
        //用户名不存在或密码错误
        if (user1 == null || !PasswordUtil.decrypt(password, user1.getPassword())) {
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "用户名或密码错误");
            meta.put("status", "500");
            return new ResponseData(null, meta);
        }

        Map data = new LinkedHashMap<>();
        data.put("id", user1.getUserId().toString());
        data.put("rid", user1.getRoleId());
        data.put("username", user1.getUsername());
        data.put("mobile", user1.getUserTel());
        data.put("email", user1.getUserEmail());
        data.put("token", "token");

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "登录成功");
        meta.put("status", "200");

        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData<Map, Map> queryAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userDao.queryAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        Map data = new LinkedHashMap<>();
        data.put("totalpage", pageInfo.getPages());
        data.put("pagenum", pageNum);
        List<Map> list = new ArrayList<>();
        for (User user : pageInfo.getList()) {
            Map map = new LinkedHashMap();
            map.put("id", user.getUserId());
            map.put("username", user.getUsername());
            map.put("mobile", user.getUserTel());
            map.put("type", user.getIsActive().equals("是")? true : false);
            map.put("email", user.getUserEmail());
            map.put("create_time", user.getCreateTime());
            map.put("mg_state", user.getIsActive().equals("是")? true : false);
            map.put("role_name", "超级管理员"); //ssssssssssssssss
            list.add(map);
        }
        data.put("users", list);

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "获取成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData<Map, Map> addUser(User user) {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        user.setCreateTime(Integer.parseInt(date));
        user.setUpdateTime(Integer.parseInt(date));
        user.setPassword(PasswordUtil.encryption(user.getPassword()));
        Integer result = userDao.addUser(user);
        if(result < 1){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "添加用户失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }
        Map data = new LinkedHashMap();
        data.put("id", user.getUserId());
        data.put("username", user.getUsername());
        data.put("mobile", user.getUserTel());
        data.put("type", false);
        data.put("openid", user.getQqOpenId());
        data.put("email", user.getUserEmail());
        data.put("create_time", user.getCreateTime());
        data.put("modify_time", null);
        data.put("is_delete", false);
        data.put("is_active", false);
        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "用户创建成功");
        meta.put("stauts", "201");
        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData<Map, Map> updateUserState(User user, String stateType) {
        Integer result = userDao.updateUserState(user, stateType);
        if(result < 1){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "设置状态失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }
        User user1 = userDao.queryById(user.getUserId());
        Map data = new LinkedHashMap();
        data.put("id", user1.getUserId());
        data.put("rid", user1.getRoleId());
        data.put("username", user1.getUsername());
        data.put("mobile", user1.getUserTel());
        data.put("email", user1.getUserEmail());
        data.put("mg_state", user1.getIsActive().equals("是") ? 1 : 0);

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "设置状态成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData<Map, Map> queryById(Integer id) {
        User user = userDao.queryById(id);
        if(user == null){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "查询失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }
        Map data = new LinkedHashMap();
        data.put("id", user.getUserId());
        data.put("username", user.getUsername());
        data.put("role_id", user.getRoleId());
        data.put("mobile", user.getUserTel());
        data.put("email", user.getUserEmail());
        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "查询成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData updateUser(User user) {
        Integer result = userDao.updateUser(user);
        if(result < 1){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "更新失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }
        User user1 = userDao.queryById(user.getUserId());
        Map data = new LinkedHashMap();
        data.put("id", user1.getUserId());
        data.put("username", user1.getUsername());
        data.put("role_id", user1.getRoleId());
        data.put("mobile", user1.getUserTel());
        data.put("email", user1.getUserEmail());

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "更新成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }

    @Override
    public ResponseData deleteById(Integer id) {
        Integer result = userDao.deleteById(id);
        if(result < 1){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "删除失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "删除成功");
        meta.put("stauts", "200");
        return new ResponseData(null, meta);
    }

    @Override
    public ResponseData<Map, Map> assignUserRole(Integer userId, Integer roleId) {
        try {
            Integer result = userDao.assignUserRole(userId, roleId);
        } catch (Exception e){
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "设置角色失败");
            meta.put("stauts", "500");
            return new ResponseData(null, meta);
        }
//        if(result < 1){
//            Map<String, String> meta = new LinkedHashMap<>();
//            meta.put("msg", "设置角色失败");
//            meta.put("stauts", "500");
//            return new ResponseData(null, meta);
//        }
        User user = userDao.queryById(userId);
        Map data = new LinkedHashMap();
        data.put("id", user.getUserId());
        data.put("rid", user.getRoleId());
        data.put("username", user.getUsername());
        data.put("mobile", user.getUserTel());
        data.put("email", user.getUserEmail());

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "设置角色成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }
}
