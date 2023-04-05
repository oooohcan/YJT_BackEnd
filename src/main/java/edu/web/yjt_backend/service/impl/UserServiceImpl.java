package edu.web.yjt_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.web.yjt_backend.model.domain.User;
import edu.web.yjt_backend.service.UserService;
import edu.web.yjt_backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author SydZh
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-04-05 22:04:07
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




