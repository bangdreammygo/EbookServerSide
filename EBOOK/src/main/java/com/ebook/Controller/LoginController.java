//已使用JPA重构
package com.ebook.Controller;
import com.ebook.entity.User;
import com.ebook.pojo.Result;
import com.ebook.service.UserService;
import com.ebook.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

//这个控制器类用来管理用户的登录信息和状态
@RestController
@CrossOrigin
//监听事务的回滚
@Transactional
public class LoginController {

    //获取service
    @Autowired
    private UserService userService;


    ///////该函数检验解码token
    @RequestMapping("/login/check")
    public Result checkLogin(String token) {
        //校验token
         try {
             Claims claims =JWTUtil.parseJwt(token);
         }
         catch (Exception e) {
             return new Result(444,"error",false);
         }
         return new Result(200,"success",true);
    }



    //////该函数用以接收前端发过来的参数，来设置用户名和密码（并不会写，只是先稍微打个demo）
    @RequestMapping("/login/setinfo")
    public Result setinfo(String username, String password){
//
//        校验用户信息
//
       boolean flag = userService.checkLogin(username,password);
       if(!flag){
           return new Result(444,"error","用户名密码错误");
       }
//
//
//        通过用户名获取到用户的id
        Long id=userService.getIdByUsername(username);
        String token= JWTUtil.generateJwt(username, id);
        return new Result(200,"success",token);
    }



    ///////该函数用于注册
    @RequestMapping("/login/reg")
    public Result regNew(@RequestBody User user){
//      查重
        if(userService.getUser(user.getUsername())!=null){
            return new Result(444,"error","用户名重复");
        }
        user.setMoney(20000000000L);
        //注册
        userService.insertUser(user);
        return new Result(200,"success","注册成功");
    }


}
