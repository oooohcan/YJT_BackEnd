package edu.web.yjt_backend.service;
import java.util.Date;

import edu.web.yjt_backend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}