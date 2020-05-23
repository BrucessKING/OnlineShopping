package top.bigking.controller;

import org.springframework.web.bind.annotation.*;
import top.bigking.annotation.AccessLimit;
import top.bigking.entity.ResponseData;
import top.bigking.service.RightService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by misty on 2020/4/21 21:57
 */

@CrossOrigin
@RestController
public class RightController {

    @Resource
    private RightService rightService;



    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @GetMapping("rights/{type}")
    @ResponseBody
    public ResponseData<Map, Map> getAllRights(@PathVariable String type){
        ResponseData responseData = null;
        responseData = rightService.getAllRight(type);
        return responseData;
    }


    @AccessLimit(seconds = 5,maxCount = 5,needLogin = true)
    @GetMapping("menus")
    ResponseData<Map, Map> getLeftMenuRights(){
        ResponseData<Map, Map> responseData = null;
        return responseData;
    }


}
