package top.bigking.entity;

/**
 * @Author ABKing
 * @since 2020/5/21 下午9:29
 **/
public class JwtData {
    private String userName;
    private String roleName;
    private String Expire;

    @Override
    public String toString() {
        return "JwtData{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", Expire='" + Expire + '\'' +
                '}';
    }

    public JwtData() {
    }

    public JwtData(String userName, String roleName, String expire) {
        this.userName = userName;
        this.roleName = roleName;
        Expire = expire;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getExpire() {
        return Expire;
    }

    public void setExpire(String expire) {
        Expire = expire;
    }
}
