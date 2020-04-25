package top.bigking.entity;

/**
 * Create by misty on 2020/4/23 17:32
 */
public class RightList {
    private Integer id;
    private  String authName;
    private String level;
    private String pid;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "RightList{" +
                "id=" + id +
                ", authName='" + authName + '\'' +
                ", level='" + level + '\'' +
                ", pid=" + pid +
                ", path='" + path + '\'' +
                '}';
    }
}
