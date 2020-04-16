package top.bigking.entity;

public class Manager {
    private Integer mgId;

    private String mgName;

    private String mgPwd;

    private Integer mgTime;

    private Byte roleId;

    private String mgMobile;

    private String mgEmail;

    private Byte mgState;

    public Integer getMgId() {
        return mgId;
    }

    public void setMgId(Integer mgId) {
        this.mgId = mgId;
    }

    public String getMgName() {
        return mgName;
    }

    public void setMgName(String mgName) {
        this.mgName = mgName == null ? null : mgName.trim();
    }

    public String getMgPwd() {
        return mgPwd;
    }

    public void setMgPwd(String mgPwd) {
        this.mgPwd = mgPwd == null ? null : mgPwd.trim();
    }

    public Integer getMgTime() {
        return mgTime;
    }

    public void setMgTime(Integer mgTime) {
        this.mgTime = mgTime;
    }

    public Byte getRoleId() {
        return roleId;
    }

    public void setRoleId(Byte roleId) {
        this.roleId = roleId;
    }

    public String getMgMobile() {
        return mgMobile;
    }

    public void setMgMobile(String mgMobile) {
        this.mgMobile = mgMobile == null ? null : mgMobile.trim();
    }

    public String getMgEmail() {
        return mgEmail;
    }

    public void setMgEmail(String mgEmail) {
        this.mgEmail = mgEmail == null ? null : mgEmail.trim();
    }

    public Byte getMgState() {
        return mgState;
    }

    public void setMgState(Byte mgState) {
        this.mgState = mgState;
    }
}