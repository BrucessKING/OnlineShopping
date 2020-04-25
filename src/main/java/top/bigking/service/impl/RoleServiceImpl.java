package top.bigking.service.impl;

import org.springframework.stereotype.Service;
import top.bigking.dao.PermissionApiDao;
import top.bigking.dao.RoleDao;
import top.bigking.entity.PermissionApi;
import top.bigking.entity.RightTree;
import top.bigking.entity.Role;
import top.bigking.entity.RoleResult;
import top.bigking.service.RoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by misty on 2020/4/21 23:04
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    @Resource
    private PermissionApiDao permissionApiDao;

    @Override
    public List<RoleResult> queryAllRoles() {
        List<RoleResult> roleResults = new ArrayList<>();
        List<Role> roles = roleDao.getAllRoles();
        List<PermissionApi> permissionApiList = permissionApiDao.getAllPermissionApis();
        Map<Integer,PermissionApi> map = new HashMap<>();
        for (PermissionApi p:permissionApiList
             ) {
            map.put(p.getPsId(),p);
        }
        for (Role r: roles
             ) {
            RoleResult roleResult = new RoleResult();
            roleResult.setId(r.getRoleId().intValue());
            roleResult.setRoleName(r.getRoleName());
            roleResult.setRoleDesc(r.getRoleDesc());
            String[] split = r.getPsIds().split(",");
            List<RightTree> rightTrees = getPermissionsResult(map, split);
            roleResult.setChildren(rightTrees);
            roleResults.add(roleResult);
        }
        return roleResults;
    }

    @Override
    public Integer addRole(Role role) {
        int flag = 0;
        if (role.getRoleName()==null||role.getRoleName().equals("")){
            return flag;
        }
        Integer a = roleDao.addRole(role);
        if (a!=null){
            flag = a;
        }
        return flag;
    }

    @Override
    public Role queryById(Integer id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRoleById(role);
    }

    @Override
    public Integer deleteRole(Integer id) {
        return roleDao.deleteRoleId(id);
    }

    @Override
    public Integer authorizeRole(Integer roleId,String rights) {
        return roleDao.updateRoleRight(roleId,rights);
    }

    @Override
    public List<RightTree> deleteRightById(Integer roleId, String rightId) {
        Integer rightid = Integer.parseInt(rightId);
        Role role = roleDao.findRoleById(roleId);
        String rights = role.getPsIds();
        String[] split = rights.split(",");
        List<PermissionApi> permissionApiList = permissionApiDao.getAllPermissionApis();
        Map<Integer,PermissionApi> map = new HashMap<>();
        for (PermissionApi p:permissionApiList
        ) {
            map.put(p.getPsId(),p);
        }
        List<RightTree> rightTrees = getPermissionsResult(map, split);
        updateRightTree(rightTrees,rightid);
        String newRight = getRightString(rightTrees);
        roleDao.updateRoleRight(roleId,newRight);
        return rightTrees;
    }





    // 获取权限树
    public List<RightTree> getPermissionsResult(Map<Integer,PermissionApi> permissionApiMap, String [] a){
        List<RightTree> rightTrees = new ArrayList<>();
        Map<Integer,RightTree> map = new HashMap<>();
        // 处理一级菜单
        for (String i:a
             ) {
            if (i==null||i.equals(""))
                continue;
            Integer permissionId = Integer.parseInt(i);
            PermissionApi permissionApi = permissionApiMap.get(permissionId);
            if (permissionApi!=null&&permissionApi.getPermission().getPsLevel().equals("0")){
                RightTree right = new RightTree();
                right.setAuthName(permissionApi.getPermission().getPsName());
                right.setId(permissionApi.getPsId());
                right.setPath(permissionApi.getPsApiPath());
                map.put(permissionApi.getPsId(),right);
            }
        }

        // 临时存储二级返回结果
        Map<Integer, RightTree> tmpResult = new HashMap<>();
        // 处理二级菜单
        for (String i:a
        ) {
            if (i==null||i.equals(""))
                continue;
            Integer permissionId = Integer.parseInt(i);
            PermissionApi permissionApi = permissionApiMap.get(permissionId);
            if (permissionApi!=null&&permissionApi.getPermission().getPsLevel().equals("1")){
                Integer pid = permissionApi.getPermission().getPsPid().intValue();
                RightTree pright = (RightTree) map.get(pid);
                if(pright!=null){
                    RightTree right = new RightTree();
                    right.setAuthName(permissionApi.getPermission().getPsName());
                    right.setId(permissionApi.getPsId());
                    right.setPath(permissionApi.getPsApiPath());
                    tmpResult.put(permissionApi.getPsId(),right);
                    pright.getChildren().add(right);
                }
            }
        }
        // 处理三级菜单
        for (String i:a
             ) {
            if (i==null||i.equals(""))
                continue;
            Integer permissionId = Integer.parseInt(i);
            PermissionApi permissionApi = permissionApiMap.get(permissionId);
            if (permissionApi!=null&&permissionApi.getPermission().getPsLevel().equals("2")){
                RightTree pright = tmpResult.get(permissionApi.getPermission().getPsPid().intValue());
                if (pright!=null){
                    RightTree right = new RightTree();
                    right.setAuthName(permissionApi.getPermission().getPsName());
                    right.setId(permissionApi.getPsId());
                    right.setPath(permissionApi.getPsApiPath());
                    pright.getChildren().add(right);
                }
            }
        }

        map.forEach((key,value)->{
            rightTrees.add(value);

        });
        return rightTrees;
    }

    // 删除某个权限后的权限树
    public void updateRightTree(List<RightTree> rightTrees,Integer rightid){
        boolean flag;
        for (RightTree r:rightTrees
        ) {
            flag = r.getId().equals(rightid);
            if(r!=null&&flag){
                rightTrees.remove(r);
                break;
            }
            List<RightTree> children = r.getChildren();
            if (children!=null){
                for (RightTree cr:children
                ) {
                    flag = cr.getId().equals(rightid);
                    if(cr!=null&&flag){
                        children.remove(cr);
                        break;
                    }
                    List<RightTree> cchildren = cr.getChildren();
                    if (cchildren!=null){
                        for (RightTree ccr:cchildren
                        ) {
                            flag = ccr.getId().equals(rightid);
                            if(ccr!=null&&flag){
                                cchildren.remove(ccr);
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    // 根据权限树获取权限
    public String getRightString(List<RightTree> rightTrees){
        System.out.println(rightTrees);
        String flag = "";
        for (RightTree r:rightTrees
             ) {
            if (r!=null){
                flag = flag+","+r.getId();
                List<RightTree> children = r.getChildren();
                for (RightTree cr:children
                     ) {
                    if (cr!=null){
                        flag = flag+","+cr.getId();
                        List<RightTree> cchildren = cr.getChildren();
                        for (RightTree ccr:cchildren
                             ) {
                            if (ccr!=null){
                                flag = flag+","+cr.getId();
                            }else {
                                continue;
                            }
                        }
                    }else{
                        continue;
                    }
                }
            }else {
                continue;
            }
        }
        System.out.println(flag);
        if (!flag.equals("")){
            flag = flag.substring(1,flag.length());
        }
        return flag;
    }







}
