package top.bigking.service;

import top.bigking.entity.Manager;
import top.bigking.entity.ResponseData;

/**
 * @Author ABKing
 * @since 2020/5/20 下午10:30
 **/
public interface ManagerService {
    ResponseData login(String username, String password) throws Exception;
}
