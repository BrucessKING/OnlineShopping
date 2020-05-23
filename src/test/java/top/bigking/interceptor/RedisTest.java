package top.bigking.interceptor;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author ABKing
 * @since 2020/5/22 上午9:52
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RedisTest {
    @Resource
    private RedisTemplate<String, Integer> redisTemplate;
    @Test
    public void redisTest(){
        String key = "/OnlineShopping_war_exploded/user/users/0/4";
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        if (increment == 0) {//初始设置过期时间
            entityIdCounter.expire(10, TimeUnit.SECONDS);
        }
        System.out.println(increment);
//        redisTemplate.opsForValue().set(key, 1);
    }
}
