package top.bigking.service;

import com.github.pagehelper.PageInfo;
import top.bigking.entity.Order;

/**
 * @Author ABKing
 * @since 2020/4/14 下午3:42
 **/
public interface OrderService {
    /**
     * 订单数据列表
     */
    PageInfo<Order> queryOrder(Integer pageNum, Integer pageSize);

    /**
     * 修改订单状态
     */
    Integer updateOrder(Order order);

    /**
     * 查看订单状态
     */
    Order queryById(Integer id);
}
