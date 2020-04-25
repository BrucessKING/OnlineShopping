package top.bigking.service.impl;

import org.springframework.stereotype.Service;
import top.bigking.dao.PermissionApiDao;
import top.bigking.entity.PermissionApi;
import top.bigking.entity.ResponseData;
import top.bigking.entity.RightList;
import top.bigking.entity.RightTree;
import top.bigking.service.RightService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by misty on 2020/4/21 23:03
 */
@Service
public class RightServiceImpl implements RightService {

//    @Resource
//    private RightDao rightDao;

    @Resource
    private PermissionApiDao permissionApiDao;

    @Override
    public ResponseData<Map, Map> getAllRight(String type) {
        Map<String,Object> data = new HashMap<>();
        Map<String,String> meta = new HashMap<>();
        ResponseData responseData = null;
        if(type==null||type!="list"||type!="tree"){
            meta.put("stauts","500");
            meta.put("msg","获取权限失败");
            responseData = new ResponseData(data,meta);
        }
        if ("list".equals(type)){
            List<PermissionApi> permissionApiList = permissionApiDao.getAllPermissionApis();
            List<RightList> rightLists = new ArrayList<>();
            for (PermissionApi p: permissionApiList
                 ) {
                RightList right = new RightList();
                right.setAuthName(p.getPermission().getPsName());
                right.setId(p.getPsId());
                right.setLevel(p.getPermission().getPsLevel());
                right.setPath(p.getPsApiPath());
                right.setPid(p.getId().toString());
                rightLists.add(right);
            }
            data.put("data",rightLists);
            meta.put("stauts","200");
            meta.put("msg","获取权限成功");
            responseData = new ResponseData(data,meta);
        }
        if ("tree".equals(type)){
            List<PermissionApi> permissionApiList = permissionApiDao.getAllPermissionApis();
            List<RightTree> rightTrees = new ArrayList<>();
            Map<Integer, Object> map = new HashMap<>();
            // 一级菜单
            for (PermissionApi p: permissionApiList
            ) {
                if(p.getPermission().getPsLevel().equals("0")){
                    RightTree right = new RightTree();
                    right.setAuthName(p.getPermission().getPsName());
                    right.setId(p.getPsId());
                    right.setPath(p.getPsApiPath());
                    right.setPid(p.getPermission().getPsPid().toString());
                    map.put(p.getPsId(),right);
                }
            }

            // 临时存储二级返回结果
            Map<Integer, Object> tmpResult = new HashMap<>();
            // 二级菜单
            for (PermissionApi p: permissionApiList
            ) {
                if(p.getPermission().getPsLevel().equals("1")){
                    Integer pid = p.getPermission().getPsPid().intValue();
                    RightTree pright = (RightTree) map.get(pid);
                    if (pright!=null){
                        RightTree right = new RightTree();
                        right.setAuthName(p.getPermission().getPsName());
                        right.setId(p.getPsId());
                        right.setPath(p.getPsApiPath());
                        right.setPid(p.getId().toString());
                        right.setPid(p.getPermission().getPsPid().toString());
                        tmpResult.put(p.getPsId(),right);

                        pright.getChildren().add(right);
                    }

                }
            }
            // 三级菜单
            for (PermissionApi p: permissionApiList
            ) {
                if(p.getPermission().getPsLevel().equals("2")){
                    RightTree pright = (RightTree) tmpResult.get(p.getPermission().getPsPid().intValue());//获取父类
                    if(pright!=null){
                        RightTree ppright = (RightTree) map.get(Integer.parseInt(pright.getPid())); //获取父父类
                        RightTree right = new RightTree();
                        right.setAuthName(p.getPermission().getPsName());
                        right.setId(p.getPsId());
                        right.setPath(p.getPsApiPath());
                        right.setPid(p.getPermission().getPsPid()+","+pright.getPid().toString());
                        pright.getChildren().add(right);
                    }
                }
            }
            map.forEach((key,value) -> {
                RightTree rightTree = (RightTree) value;
                rightTrees.add(rightTree);
            });
            data.put("data",rightTrees);
            meta.put("stauts","200");
            meta.put("msg","获取权限成功");
            responseData = new ResponseData(data,meta);
        }
        return responseData;
    }

    @Override
    public ResponseData<Map, Map> getLeftMenuRights() {
        return null;
    }
}
