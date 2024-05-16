package com.ebook.service;


//user相关服务


import com.ebook.entity.User;

public interface UserService {
    public User insertUser(User user);
    public User updateUser(User user);
    public boolean checkLogin(String username, String password);
    public User getUser(String username);
    public Long getIdByUsername(String username);
    public User getUserById(Long id);
}
