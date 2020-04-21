package top.bigking.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Create by misty on 2020/4/21 21:11
 */
public class PasswordUtil {

    /**
     *
     * @param pwd  明文
     * @return  返回密文
     */
    public static String encryption(String pwd){
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        String encode = bcp.encode(pwd);
        return encode;
    }

    /**
     *
     * @param pwdone 明文
     * @param pwdtwo 从数据库中获取的加密的密文
     * @return
     */
    public static boolean decrypt(String pwdone,String pwdtwo){
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        return bcp.matches(pwdone,pwdtwo);
    }

}
