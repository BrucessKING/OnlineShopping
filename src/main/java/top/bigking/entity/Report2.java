package top.bigking.entity;

import java.util.Date;

public class Report2 {
    private Integer id;

    private String rp2Page;

    private Integer rp2Count;

    private Date rp2Date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRp2Page() {
        return rp2Page;
    }

    public void setRp2Page(String rp2Page) {
        this.rp2Page = rp2Page == null ? null : rp2Page.trim();
    }

    public Integer getRp2Count() {
        return rp2Count;
    }

    public void setRp2Count(Integer rp2Count) {
        this.rp2Count = rp2Count;
    }

    public Date getRp2Date() {
        return rp2Date;
    }

    public void setRp2Date(Date rp2Date) {
        this.rp2Date = rp2Date;
    }
}