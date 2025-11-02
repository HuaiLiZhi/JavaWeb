package com.huailizhi.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    
    private static final String SIGN_KEY = "aHVhaWxpemhp";
    private static final Long EXPIRE_TIME = 12 * 60 * 60 * 1000L; // 12小时
    
    /**
     * 生成JWT令牌
     * @param claims 自定义数据
     * @return JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .compact();
    }
    
    /**
     * 解析JWT令牌
     * @param token JWT令牌
     * @return 解析后的Claims对象
     */
    public static Claims parseJWT(String token) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}