//已使用JPA重构
package com.ebook.Controller;


//有关用户信息的controller


import com.ebook.entity.User;
import com.ebook.pojo.Result;
import com.ebook.service.UserService;
import com.ebook.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
public class UserController {
//    获取服务
    @Autowired
    private UserService userService;


//    获取用户的信息
    @RequestMapping("/user/info")
    public Result getUserInfo(String token) {
        Claims claims = JWTUtil.parseJwt(token);
        String username = claims.get("username",String.class);
        return new Result(200,"success",userService.getUser(username));
    }
//    修改用户签名
    @RequestMapping("/user/motto")
    public Result ModifyMotto(String token,String motto) {
        Claims claims = JWTUtil.parseJwt(token);
        String username = claims.get("username",String.class);
        User user = userService.getUser(username);
        user.setMotto(motto);
        userService.updateUser(user);
        return new Result(200,"success",userService.getUser(username).getMotto());
    }




}
