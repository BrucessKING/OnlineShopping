package top.bigking.dao;

import org.apache.ibatis.annotations.Param;
import top.bigking.entity.Role;

import java.util.List;

/**
 * Create by misty on 2020/4/24 11:04
 */
public interface RoleDao {
    public List<Role> getAllRoles();
    public Integer addRole(Role role);
    public Role findRoleById(Integer id);
    public Integer updateRoleById(Role role);
    public Integer deleteRoleId(Integer id);
    public Integer updateRoleRight(@Param("roleId") Integer roleId, @Param("rights") String rights);
}
