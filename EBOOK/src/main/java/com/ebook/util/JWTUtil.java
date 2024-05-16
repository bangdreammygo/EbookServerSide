package com.ebook.util;


//生成jwt令牌的工具类
//使用token代替session


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    //生成令牌的方法
    private static String key="dingjiangfan";
    //该令牌的持续时间
    private static Long  expire=43200000L;


    //生成token令牌
    public static String generateJwt(String username, Long id){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", username);
        claims.put("id", id);
        //生成token令牌
        String jwt =Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }
    //解析token令牌
    public static Claims parseJwt(String jwt){
        Claims claims= Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();

        //获取jwt令牌
        return claims;
    }





}
