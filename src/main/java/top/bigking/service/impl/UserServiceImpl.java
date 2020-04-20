package top.bigking.service.impl;

import org.springframework.stereotype.Service;
import top.bigking.dao.UserDao;
import top.bigking.entity.ResponseData;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;
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
        Map<String, Map> map = new LinkedHashMap<>();

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

        map.put("data", data);
        map.put("meta", meta);

        return new ResponseData(data, meta);
    }

    @Override
    public List<User> queryAllUsers(Integer pageNum, Integer pageSize) {
        return null;
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
