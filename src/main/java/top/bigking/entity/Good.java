package top.bigking.entity;

import java.math.BigDecimal;

public class Good {
    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsNumber;

    private Short goodsWeight;

    private Short catId;

    private String goodsBigLogo;

    private String goodsSmallLogo;

    private String isDel;

    private Integer addTime;

    private Integer updTime;

    private Integer deleteTime;

    private Short catOneId;

    private Short catTwoId;

    private Short catThreeId;

    private Integer hotMumber;

    private Short isPromote;

    private Integer goodsState;

    private String goodsIntroduce;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Short getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Short goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public Short getCatId() {
        return catId;
    }

    public void setCatId(Short catId) {
        this.catId = catId;
    }

    public String getGoodsBigLogo() {
        return goodsBigLogo;
    }

    public void setGoodsBigLogo(String goodsBigLogo) {
        this.goodsBigLogo = goodsBigLogo == null ? null : goodsBigLogo.trim();
    }

    public String getGoodsSmallLogo() {
        return goodsSmallLogo;
    }

    public void setGoodsSmallLogo(String goodsSmallLogo) {
        this.goodsSmallLogo = goodsSmallLogo == null ? null : goodsSmallLogo.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Integer updTime) {
        this.updTime = updTime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Short getCatOneId() {
        return catOneId;
    }

    public void setCatOneId(Short catOneId) {
        this.catOneId = catOneId;
    }

    public Short getCatTwoId() {
        return catTwoId;
    }

    public void setCatTwoId(Short catTwoId) {
        this.catTwoId = catTwoId;
    }

    public Short getCatThreeId() {
        return catThreeId;
    }

    public void setCatThreeId(Short catThreeId) {
        this.catThreeId = catThreeId;
    }

    public Integer getHotMumber() {
        return hotMumber;
    }

    public void setHotMumber(Integer hotMumber) {
        this.hotMumber = hotMumber;
    }

    public Short getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Short isPromote) {
        this.isPromote = isPromote;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce == null ? null : goodsIntroduce.trim();
    }
}