package top.bigking.util;

import org.junit.Test;

/**
 * @Author ABKing
 * @since 2020/4/21 下午10:00
 **/
public class PasswordUtilTest {
    @Test
    public void encryptionTest() {
        String password = PasswordUtil.encryption("admin");
        System.out.println(password);
    }

    @Test
    public void decryptTest() {
        boolean result = PasswordUtil.decrypt("123456", "$2a$10$0JkZ1/jLQp7XRcBVDIcOoulQN.5V9wF3mqB8iDdE8zUkQmgeYBhOW");
        System.out.println(result);
    }
}
