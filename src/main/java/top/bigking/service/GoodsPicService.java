package top.bigking.service;

import top.bigking.entity.GoodsPic;

/**
 * @Author ABKing
 * @since 2020/4/14 下午3:26
 * 商品图片
 **/
public interface GoodsPicService {
    /**
     * 图片上传
     */
    Integer addGoodsPic(GoodsPic goodsPic);
}
