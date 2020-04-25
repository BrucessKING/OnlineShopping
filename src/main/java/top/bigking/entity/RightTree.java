package top.bigking.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by misty on 2020/4/23 17:34
 */
public class RightTree {
    private Integer id;
    private  String authName;
    private String pid;
    private String path;
    private List<RightTree> children = new ArrayList<>();

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

    public List<RightTree> getChildren() {
        return children;
    }

    public void setChildren(List<RightTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RightTree{" +
                "id=" + id +
                ", authName='" + authName + '\'' +
                ", pid='" + pid + '\'' +
                ", path='" + path + '\'' +
                ", children=" + children +
                '}';
    }
}
