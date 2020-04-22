package top.bigking.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        boolean result = PasswordUtil.decrypt("123456", "$2a$10$bYL5fKBHK0diP1tEWEwbPuQ0KxHt0iM5v7h28wMSOxd6PmLK7.vVS");
        System.out.println(result);
    }

}
