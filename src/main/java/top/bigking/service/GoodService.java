package top.bigking.service;

import com.github.pagehelper.PageInfo;
import top.bigking.entity.Good;

/**
 * @Author ABKing
 * @since 2020/4/13 下午10:11
 * 商品
 **/
public interface GoodService {
    /**
     * 商品列表数据
     */
    PageInfo<Good> queryAllGoods(Integer pageNum, Integer pageSize);

    /**
     * 添加商品
     */
    Integer addGoods(Good good);

    /**
     * 根据ID查询商品
     */
    Good queryById(Integer id);

    /**
     * 编辑提交商品（修改商品信息）
     */
    Integer updateGood(Good good);

    /**
     * 删除商品
     */
    Integer deleteById(Integer id);

}
