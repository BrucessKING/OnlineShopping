package top.bigking.service;

import top.bigking.entity.RightTree;
import top.bigking.entity.Role;
import top.bigking.entity.RoleResult;

import java.util.List;

/**
 * @Author ABKing
 * @since 2020/4/13 下午3:55
 *
 * 角色
 **/
public interface RoleService {
    /**
     * 获取角色列表
     */
    List<RoleResult> queryAllRoles();

    /**
     * 添加角色
     */
    Integer addRole(Role role);

    /**
     * 根据ID查询角色
     */
    Role queryById(Integer id);

    /**
     * 编辑角色
     */
    Integer updateRole(Role role);

    /**
     * 删除角色
     */
    Integer deleteRole(Integer id);

    /**
     * 角色授权(更新Role表的数据)
     */
    Integer authorizeRole(Integer roleId, String rights);

    /**
     * 删除指定角色权限(从Role的ps_ids字段中删除指定的rightId)
     */
    List<RightTree> deleteRightById(Integer roleId, String rightId);

}
