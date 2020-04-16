package top.bigking.dao;

import org.apache.ibatis.annotations.Param;
import top.bigking.entity.User;

import java.util.List;

/**
 * @Author ABKing
 * @since 2020/4/14 下午4:50
 **/
public interface UserDao {
    /**
     * 登录
     */
    User login(String username, String password);

    /**
     * 用户管理，查询所有用户信息
     */
    List<User> queryAllUsers();

    /**
     * 添加用户
     */
    Integer addUser(User user);

    /**
     * 修改用户状态
     */
    Integer updateUserState(User user, String stateType);

    /**
     * 根据ID查询用户信息
     */
    User queryById(Integer id);

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
