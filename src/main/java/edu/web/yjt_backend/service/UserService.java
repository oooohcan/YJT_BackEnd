package edu.web.yjt_backend.service;

import edu.web.yjt_backend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author SydZh
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-04-05 22:04:07
*/
public interface UserService extends IService<User> {
    /**
     *用户注册
     * @param userAccount       账户
     * @param userPassword      密码
     * @param checkPassword     校验密码
     * @param inviteCode        邀请码
     * @return  状态码
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String inviteCode);

    /**
     *用户登录
     * @param userAccount       账户
     * @param userPassword      密码
     * @param request
     * @return  脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 搜索用户
     * @param username
     * @param request
     * @return
     */
    List<User> searchUser(String username, HttpServletRequest request);

    /**
     * 删除用户
     * @param id
     * @param request
     * @return
     */
    boolean deleteUser(long id, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return 脱敏后的用户
     */
    User getSafetyUser(User originUser);

    /**
     * 是否管理员
     * @param request
     * @return 判断结果
     */
    boolean isAdmin(HttpServletRequest request);
}
