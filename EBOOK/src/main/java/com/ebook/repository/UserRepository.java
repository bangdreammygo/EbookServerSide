package com.ebook.repository;

import com.ebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//数据库操作


public interface UserRepository extends JpaRepository<User,Long> {
//    根据用户名查找
//    由于使用token所以相对安全
    @Query(value = "select * from tb_user where username=?1", nativeQuery = true)
    User findByUsername(String username);
//    登陆时的校验查找
    @Query(value = "select * from tb_user where username=?1 and password=?2", nativeQuery = true)
    User CheckUser(String username,String password);
//    通过id获取用户
    @Query(value = "select * from tb_user where id = ?1",nativeQuery = true)
    public User getUserById(Long id);
}
