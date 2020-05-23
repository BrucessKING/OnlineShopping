package top.bigking.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.bigking.annotation.AccessLimit;
import top.bigking.entity.ResponseData;
import top.bigking.exception.BaseException;
import top.bigking.util.JwtUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author ABKing
 * @since 2020/5/22 上午9:08
 **/


public class AccessInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /*改写这个方法，表示在方法执行之前拦截*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTIONS".equals(method))
            return true;
        String token = request.getHeader("Authorization");
        Claims claims = JwtUtil.parseJWT(token.replace("Bearer ", ""));
        if (claims == null) {
            return false;
        }
        HandlerMethod hm = (HandlerMethod) handler;
        AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
        if (accessLimit == null) {
            return true;//没有注解 就放行表示执行完成
        }
        int maxCount = accessLimit.maxCount();//获取方法上注解的参数
        int seconds = accessLimit.seconds();
        boolean needLogin = accessLimit.needLogin();//判断登录 这里需要拿到用户User

        String urlKey = request.getRequestURI(); //获取请求接口的URL

        RedisAtomicLong entityIdCounter = new RedisAtomicLong(urlKey, redisTemplate.getConnectionFactory());
        long increment = entityIdCounter.getAndIncrement();
        if (increment == 0) {//初始设置过期时间
            entityIdCounter.expire(seconds, TimeUnit.SECONDS);
        }
        if (increment > maxCount - 1) {
            return false;
        }

        return true;
    }
}
