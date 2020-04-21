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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        User user1 = userDao.login(username, password);
        //用户名不存在或密码错误
        if (user1 == null || !PasswordUtil.decrypt(password, user1.getPassword())) {
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("msg", "用户名或密码错误");
            meta.put("status", "500");
            return new ResponseData(null, meta);
        }

        Map<String, String> data = new LinkedHashMap<>();
        data.put("id", user1.getUserId().toString());
        data.put("rid", "0");
        data.put("username", user1.getUsername());
        data.put("mobile", "123");
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
            map.put("type", 1);
            map.put("email", user.getUserEmail());
            map.put("create_time", user.getCreateTime());
            map.put("mg_state", user.getIsActive().equals("是")? true : false);
            map.put("role_name", "超级管理员");
            list.add(map);
        }
        data.put("users", list);

        Map<String, String> meta = new LinkedHashMap<>();
        meta.put("msg", "获取成功");
        meta.put("stauts", "200");
        return new ResponseData(data, meta);
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }

    @Override
    public Integer updateUserState(User user, String stateType) {
        return null;
    }

    @Override
    public User queryById(Integer id) {
        return null;
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public void assignUserRole(Integer userId, Integer roleId) {

    }
}
