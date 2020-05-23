package top.bigking.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import top.bigking.constant.Constant;
import top.bigking.dao.ManagerDao;
import top.bigking.dao.RoleDao;
import top.bigking.entity.JwtData;
import top.bigking.entity.Manager;
import top.bigking.entity.ResponseData;
import top.bigking.entity.Role;
import top.bigking.service.ManagerService;
import top.bigking.util.JwtUtil;
import top.bigking.util.PasswordUtil;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author ABKing
 * @since 2020/5/20 下午10:31
 **/
@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public ResponseData login(String username, String password) throws Exception {
        Manager manager = managerDao.login(username);
        //用户名不存在或密码错误
        if (manager == null || !PasswordUtil.decrypt(password, manager.getMgPwd())) {
            Map meta = new LinkedHashMap<>();
            meta.put("msg", "用户名或密码错误");
            meta.put("status", 500);
            return new ResponseData(null, meta);
        }

        Map data = new LinkedHashMap<>();
        data.put("id", manager.getMgId().toString());
        data.put("rid", manager.getRoleId());
        data.put("username", manager.getMgName());
        data.put("mobile", manager.getMgMobile());
        data.put("email", manager.getMgEmail());


        JwtData jwtData = new JwtData();
        jwtData.setUserName(manager.getMgName());
        Role role = roleDao.findRoleById(manager.getRoleId().intValue());
        jwtData.setRoleName(role.getRoleName());

        Date date = new Date(new Date().getTime() + Constant.JWT_TTL);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(date);
        jwtData.setExpire(dateStr);

        String jwt = JwtUtil.createJWT(Constant.JWT_ID, JSON.toJSONString(jwtData), Constant.JWT_TTL);
        redisTemplate.opsForValue().set("jwt-" + jwt, manager.toString(), Constant.JWT_TTL, TimeUnit.MILLISECONDS);
        data.put("token", jwt);

        Map meta = new LinkedHashMap<>();
        meta.put("msg", "登录成功");
        meta.put("status", 200);

        return new ResponseData(data, meta);
    }
}
