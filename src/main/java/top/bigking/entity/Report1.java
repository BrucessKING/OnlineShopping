package top.bigking.entity;

import java.util.Date;

public class Report1 {
    private Integer id;

    private Integer rp1UserCount;

    private String rp1Area;

    private Date rp1Date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRp1UserCount() {
        return rp1UserCount;
    }

    public void setRp1UserCount(Integer rp1UserCount) {
        this.rp1UserCount = rp1UserCount;
    }

    public String getRp1Area() {
        return rp1Area;
    }

    public void setRp1Area(String rp1Area) {
        this.rp1Area = rp1Area == null ? null : rp1Area.trim();
    }

    public Date getRp1Date() {
        return rp1Date;
    }

    public void setRp1Date(Date rp1Date) {
        this.rp1Date = rp1Date;
    }
}