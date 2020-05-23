package top.bigking.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;
import top.bigking.constant.Constant;
import top.bigking.entity.JwtData;
import top.bigking.entity.Manager;

import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ABKing
 * @since 2020/5/21 下午6:17
 **/
public class JwtUtilTest {
    @Test
    public void testCreateJwt(){
        Manager manager = new Manager();
        manager.setMgName("admin");
        manager.setMgPwd(PasswordUtil.encryption("123456"));
        String subject = JSON.toJSONString(manager);
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        Date now = new Date(nowMillis);
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setId(Constant.JWT_ID)                    //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)            //iat: jwt的签发时间
                .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(key);     //设置签名使用的签名算法和签名使用的秘钥
        if (Constant.JWT_TTL >= 0) {
            long expMillis = nowMillis + Constant.JWT_TTL;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);        //设置过期时间
        }
        String str = builder.compact();
        System.out.println(str);
    }


    @Test
    public void testJwt3() throws Exception {
        Manager manager = new Manager();
//        manager.setMgName("admin");
//        manager.setMgPwd(PasswordUtil.encryption("123456"));

        manager.setMgName("admin");
        manager.setRoleId((byte) 0);
        manager.setMgState((byte) 0);
        String jwt = JwtUtil.createJWT(Constant.JWT_ID, JSON.toJSONString(manager), Constant.JWT_TTL);
        System.out.println(jwt);
    }
    @Test
    public void testParseJwt3(){
        String jwtStr = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QtQUJLaW5nIiwiaWF0IjoxNTkwMDcyMjk5LCJzdWIiOiJ7XCJleHBpcmVcIjpcIjIwMjAtMDUtMjEgMjM6NDQ6NTlcIixcInJvbGVOYW1lXCI6XCLkuLvnrqFcIixcInVzZXJOYW1lXCI6XCJhZG1pblwifSIsImV4cCI6MTU5MzY3MjI5OX0.pudFGKXBI0pduSZhmzdbMGCyGMaNFfd2sQHSu4106IQ";
        Claims claims = JwtUtil.parseJWT(jwtStr);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        JwtData jwtData = JSON.toJavaObject(jsonObject, JwtData.class);
        System.out.println(jwtData);
    }
    @Test
    public void testExpire(){
        Date date = new Date();
        long dateStr = date.getTime() + Constant.JWT_TTL;
        Date date2 = new Date(dateStr);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.format(date2));

    }
}
