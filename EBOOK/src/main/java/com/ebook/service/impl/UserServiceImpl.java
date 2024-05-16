package com.ebook.service.impl;

import com.ebook.entity.User;
import com.ebook.repository.UserRepository;
import com.ebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    //注册新用户
    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }
    //更新用户信息
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    //登录校验
    @Override
    public boolean checkLogin(String username, String password){
        User user = userRepository.CheckUser(username,password);
        if(user != null){
            return true;
        }
        return false;
    }
    //获取用户信息
    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }
    //通过用户名获取用户id
    @Override
    public Long getIdByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user.getId();
    }
    @Override
    public User getUserById(Long id){
        return userRepository.getUserById(id);
    }
}
