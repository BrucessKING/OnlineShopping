package top.bigking.dao;

import top.bigking.entity.Manager;

/**
 * @Author ABKing
 * @since 2020/5/20 下午10:48
 **/
public interface ManagerDao {
    Manager login(String username);
}
