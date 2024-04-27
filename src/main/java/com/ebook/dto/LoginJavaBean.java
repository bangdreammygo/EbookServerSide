package com.ebook.dto;




///////////这个javabean用以记录所有的登录信息
public class LoginJavaBean {
    //记录是否登录
    private boolean LoginState;
    private String username;
    private String password;
    public LoginJavaBean() {
        //初始状态未登录
        LoginState=false;
    }

    public void setLoginState(boolean loginState) {
        this.LoginState = loginState;
    }
    public boolean getLoginState() {
        return LoginState;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
