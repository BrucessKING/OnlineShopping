package top.bigking.service.impl;

import org.springframework.stereotype.Service;
import top.bigking.dao.UserDao;
import top.bigking.entity.User;
import top.bigking.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ABKing
 * @since 2020/4/14 下午4:53
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public List<User> queryAllUsers() {
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
