package com.ebook.Controller;
import com.ebook.dto.LoginJavaBean;
import com.ebook.dto.UserInfoJavaBean;
import org.springframework.web.bind.annotation.*;

//这个控制器类用来管理用户的登录信息和状态
@RestController
@CrossOrigin
public class LoginController {
    //首先创建一个对象记录所有的登录信息
    private LoginJavaBean LoginInformation;
    public LoginController() {
        //初始化
        LoginInformation = new LoginJavaBean();
    }





    ///////该函数记录登录状态，向前端返回是否登录
    @RequestMapping("/login/check")
    public int checkLogin() {
        if(LoginInformation.getLoginState())return 1;
        else return 0;
    }



    /////该函数获取当前登录用户的信息
    @RequestMapping("/login/user")
    public LoginJavaBean getLoginInformation(){
        return LoginInformation;
    }


    //////该函数用以接收前端发过来的参数，来设置用户名和密码（并不会写，只是先稍微打个demo）
    @RequestMapping("/login/setinfo")
    public boolean setinfo(@RequestBody UserInfoJavaBean User){
        LoginInformation.setLoginState(true);
        LoginInformation.setPassword(User.getPassword());
        LoginInformation.setUsername(User.getUsername());
        System.out.println(User.getUsername());
        return  true;
    }



    ///////该函数用于退出登录
    @RequestMapping("/login/logout")
    public void breakLogin(){
        LoginInformation.setLoginState(false);
        LoginInformation.setPassword("");
        LoginInformation.setUsername("");
    }


}
