package top.bigking.service;

import top.bigking.entity.ResponseData;
import top.bigking.entity.User;

import java.util.Map;

/**
 * @Author ABKing
 * @since 2020/4/13 下午1:02
 *
 * 用户
 **/
public interface UserService {
    /**
     * 登录
     */
    ResponseData login(String username, String password);
    /**
     * 用户管理，查询所有用户信息
     */
    ResponseData queryAllUsers(Integer pageNum, Integer pageSize);

    /**
     * 添加用户
     */
    ResponseData addUser(User user);

    /**
     * 修改用户状态
     */
    ResponseData updateUserState(User user, String stateType);

    /**
     * 根据ID查询用户信息
     */
    ResponseData queryById(Integer id);

    /**
     * 编辑用户提交
     */
    Integer updateUser(User user);

    /**
     * 删除单个用户
     */
    Integer deleteById(Integer id);

    /**
     * 分配用户角色
     */
    void assignUserRole(Integer userId, Integer roleId);

}
