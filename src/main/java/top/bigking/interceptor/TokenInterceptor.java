package top.bigking.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import top.bigking.exception.BaseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ABKing
 * @since 2020/5/15 下午11:35
 **/
public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if("OPTIONS".equals(method))
            return true;
        String token = request.getHeader("Authorization");
        if (token == null || token.equals("")) {
            throw new BaseException(500, "token为空!");
        }
        token = token.replace("Bearer ", "");
        return redisTemplate.hasKey("jwt-" + token);

//        Claims claims = JwtUtil.parseJWT(token.replace("Bearer ", ""));
//        if (claims != null){
//            String subject = claims.getSubject();
//            JSONObject jsonObject = JSON.parseObject(subject);
//            Manager manager = JSON.toJavaObject(jsonObject, Manager.class);
//            logger.info("token parse success {}", manager.toString());
//            return true;
//        }
//        return false;

    }
}
