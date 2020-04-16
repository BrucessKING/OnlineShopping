package top.bigking.entity;

public class GoodsPic {
    private Integer picsId;

    private Integer goodsId;

    private String picsBig;

    private String picsMid;

    private String picsSma;

    public Integer getPicsId() {
        return picsId;
    }

    public void setPicsId(Integer picsId) {
        this.picsId = picsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicsBig() {
        return picsBig;
    }

    public void setPicsBig(String picsBig) {
        this.picsBig = picsBig == null ? null : picsBig.trim();
    }

    public String getPicsMid() {
        return picsMid;
    }

    public void setPicsMid(String picsMid) {
        this.picsMid = picsMid == null ? null : picsMid.trim();
    }

    public String getPicsSma() {
        return picsSma;
    }

    public void setPicsSma(String picsSma) {
        this.picsSma = picsSma == null ? null : picsSma.trim();
    }
}