package top.bigking.entity;

import java.util.List;

/**
 * Create by misty on 2020/4/24 11:29
 */
public class RoleResult {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<RightTree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<RightTree> getChildren() {
        return children;
    }

    public void setChildren(List<RightTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RoleResult{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", children=" + children +
                '}';
    }
}
