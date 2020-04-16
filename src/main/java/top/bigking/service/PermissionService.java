package top.bigking.service;

import top.bigking.entity.Permission;
import top.bigking.entity.User;

import java.util.List;

/**
 * @Author ABKing
 * @since 2020/4/13 下午1:25
 *
 * 权限
 **/
public interface PermissionService {
    /**
     * 所有权限
     */
    List<Permission> queryAllPermissions();

    /**
     * 左侧菜单权限
     */
    List<Permission> queryMyPermission(User user);

}
