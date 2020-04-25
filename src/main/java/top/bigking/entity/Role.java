package top.bigking.entity;

public class Role {
    private Short roleId;

    private String roleName;

    private String psIds;

    private String psCa;

    private String roleDesc;

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getPsIds() {
        return psIds;
    }

    public void setPsIds(String psIds) {
        this.psIds = psIds == null ? null : psIds.trim();
    }

    public String getPsCa() { return psCa; }

    public void setPsCa(String psCa) { this.psCa = psCa; }

    public String getRoleDesc() { return roleDesc; }

    public void setRoleDesc(String roleDesc) { this.roleDesc = roleDesc; }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", psIds='" + psIds + '\'' +
                ", psCa='" + psCa + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}