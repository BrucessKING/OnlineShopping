package top.bigking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.bigking.entity.Manager;
import top.bigking.entity.ResponseData;
import top.bigking.service.ManagerService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author ABKing
 * @since 2020/5/20 下午10:30
 **/
@Controller
@CrossOrigin
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("login")
    @ResponseBody
    public ResponseData<Map, Map> login(@RequestBody Manager manager) throws Exception {
        return managerService.login(manager.getMgName(), manager.getMgPwd());
    }
}
