package top.bigking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author ABKing
 * @since 2020/3/4 下午5:34
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true) //允许带上cookies
                .allowedHeaders("*") //允许任意请求头
                .allowedMethods("*") //允许任意请求头(GET or POST)
                .allowedOrigins("*"); //允许跨域的域名， * 表示允许任意域名使用
    }
}
