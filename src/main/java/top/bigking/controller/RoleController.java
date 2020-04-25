package top.bigking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.bigking.entity.ResponseData;
import top.bigking.entity.RightTree;
import top.bigking.entity.Role;
import top.bigking.entity.RoleResult;
import top.bigking.service.RoleService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by misty on 2020/4/21 22:46
 */
@Controller
public class RoleController {


    @Resource
    private RoleService roleService;




    @GetMapping("roles")
    @ResponseBody
    ResponseData<Map, Map> getRoles(){
        List<RoleResult> roleResults = roleService.queryAllRoles();
        Map<String,Object> data = new HashMap<>();
        data.put("data",roleResults);
        Map<String,Object> meta = new HashMap<>();
        meta.put("msg","获取成功");
        meta.put("status",200);
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }

    @PostMapping("roles")
    @ResponseBody
    ResponseData<Map, Map> addRole(@RequestBody Role role){
        Integer flag = roleService.addRole(role);
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if (flag==0){
            meta.put("msg","添加角色失败");
            meta.put("status",500);
        }else {
            meta.put("msg","添加角色成功");
            meta.put("status",200);
            data.put("data",role);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }


    @GetMapping("roles/{id}")
    @ResponseBody
    ResponseData<Map, Map> findRoleById(@PathVariable String id){
        Role role = roleService.queryById(Integer.parseInt(id));
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if(role!=null){
            data.put("data",role);
            meta.put("msg","获取角色成功");
            meta.put("status",200);
        }else {
            meta.put("msg","获取角色失败");
            meta.put("status",500);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }


    @PutMapping("roles/{id}")
    @ResponseBody
    ResponseData<Map, Map> editRoleById(@PathVariable String id,@RequestBody Role role){
        role.setRoleId(Short.parseShort(id));
        Integer a = roleService.updateRole(role);
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if(a!=null){
            data.put("data",role);
            meta.put("msg","编辑角色成功");
            meta.put("status",200);
        }else {
            meta.put("msg","编辑角色失败");
            meta.put("status",500);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }


    @DeleteMapping("roles/{id}")
    @ResponseBody
    ResponseData<Map, Map> deleteRoleById(@PathVariable String id){
        Integer a = roleService.deleteRole(Integer.parseInt(id));
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if(a==null||a==0){
            meta.put("msg","删除角色失败");
            meta.put("status",500);
        }else {
            meta.put("msg","删除角色成功");
            meta.put("status",200);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }


    @PostMapping("roles/{roleId}/rights")
    @ResponseBody
    ResponseData<Map, Map> giveRoleRightsById(@PathVariable String roleId,@RequestBody Map<String,String> map){
        String rids = map.get("rids");
        Integer a = roleService.authorizeRole(Integer.parseInt(roleId),rids);
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if(a==null||a==0){
            meta.put("msg","角色授权失败");
            meta.put("status",500);
        }else {
            meta.put("msg","角色授权成功");
            meta.put("status",200);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }

    @DeleteMapping("roles/{roleId}/rights/{rightId}")
    @ResponseBody
    ResponseData<Map, Map> deleteRoleRightsById(@PathVariable String roleId,@PathVariable String rightId){
        List<RightTree> rightTrees = roleService.deleteRightById(Integer.parseInt(roleId), rightId);
        Map<String,Object> meta = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        if(rightTrees==null){
            meta.put("msg","删除权限失败");
            meta.put("status",500);
        }else {
            data.put("data",rightTrees);
            meta.put("msg","删除权限成功");
            meta.put("status",200);
        }
        ResponseData responseData = new ResponseData(data,meta);
        return responseData;
    }


}
