package top.bigking.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bigking.dao.UserDao;
import top.bigking.entity.User;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ABKing
 * @since 2020/4/22 下午9:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UserServiceTest {
    @Resource
    private UserDao userDao;
    @Test
    public void test123(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println((int)date.getTime());
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(date));
    }

    @Test
    public void updateUserStateTest(){
        User user = new User();
        user.setUserId(22);
        Boolean stateType = true;
        Integer result = userDao.updateUserState(user, stateType ? "是" : "否");
    }
    @Test
    public void queryByIdTest(){
        User user = userDao.queryById(22);
        System.out.println(user.getUsername());
    }
}
