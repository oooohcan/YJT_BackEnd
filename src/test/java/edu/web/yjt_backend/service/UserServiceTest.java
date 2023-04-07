package edu.web.yjt_backend.service;
import java.util.Date;

import edu.web.yjt_backend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {
    @Resource UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("testnie");
        user.setUserAccount("100001");
        user.setAvatarUrl("https://img.ddtouxiang.com/upload/touxiang/20230217/0217014009152717.jpg_preview.jpg");
        user.setGender(0);
        user.setUserPassword("12345678");
        user.setPhone("138220");
        user.setEmail("138220@sb.com");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }
    @Test
    void testDigest(){
        final String SALT = "Abc123@#";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+"myPassword").getBytes());
        System.out.println(encryptPassword);
    }

    //要测下面这俩得把userServiceImpl中的 throw 全改成return -1;
    @Test
    void userRegister() {
        String userAccount = "test1";
        String userPassword = "";
        String checkPassword = "12345678";
        String inviteCode="x123";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        userAccount = "ha";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        userAccount = "ha ha";
        userPassword = "12345678";
        //空格未过滤
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        userAccount = "hahaha";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);

        userAccount = "wdnmd";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1, result);
//        Assertions.assertTrue(result > 0);
    }

    @Test
    void userRegisterInviteTest(){
        String userAccount = "test1";
        String userPassword = "12345678";
        String checkPassword = "12345678";
        String inviteCode = "hhhh";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1,result);

        inviteCode = "ha002";
        result = userService.userRegister(userAccount, userPassword, checkPassword,inviteCode);
        Assertions.assertEquals(-1,result);
//        Assertions.assertTrue(result > 0);
    }
}