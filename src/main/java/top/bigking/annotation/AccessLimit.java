package top.bigking.annotation;

/**
 * @Author ABKing
 * @since 2020/5/22 上午9:07
 * 自定义注解
 * 接口防刷限流
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//运行期间有效
@Target(ElementType.METHOD)//注解类型为方法注解
public @interface AccessLimit {
    int seconds(); //固定时间
    int maxCount();//最大访问次数
    boolean needLogin() default true;// 用户是否需要登录
}
