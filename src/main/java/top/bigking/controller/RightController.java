package top.bigking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.bigking.entity.ResponseData;
import top.bigking.service.RightService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by misty on 2020/4/21 21:57
 */


@RestController
public class RightController {

    @Resource
    private RightService rightService;



    @GetMapping("rights/{type}")
    @ResponseBody
    public ResponseData<Map, Map> getAllRights(@PathVariable String type){
        ResponseData responseData = null;
        responseData = rightService.getAllRight(type);
        return responseData;
    }


    @GetMapping("menus")
    ResponseData<Map, Map> getLeftMenuRights(){
        ResponseData<Map, Map> responseData = null;
        return responseData;
    }


}
