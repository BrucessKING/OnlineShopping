package top.bigking.service;

import top.bigking.entity.ResponseData;

import java.util.Map;

/**
 * Create by misty on 2020/4/21 23:02
 */
public interface RightService {

    public ResponseData<Map, Map> getAllRight(String type);

    public ResponseData<Map, Map> getLeftMenuRights();

}
