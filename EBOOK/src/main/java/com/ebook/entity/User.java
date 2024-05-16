package com.ebook.entity;


//user用户的实体类

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    //用户id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户名
    @Column(name = "username")
    private String username;
    //密码
    @Column(name = "password")
    private String password;
    //个性签名
    @Column(name = "motto")
    private String motto;
    //余额
    @Column(name = "money")
    private Long money;
    //是否是管理员
    @Column(name = "isworker")
    private int isworker;
}
