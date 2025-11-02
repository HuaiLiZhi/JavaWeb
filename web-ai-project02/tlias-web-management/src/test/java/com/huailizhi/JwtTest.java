package com.huailizhi;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aHVhaWxpemhp")
                .addClaims(dataMap) //添加自定义数据
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置过期时间
                .compact();//生成jwt

        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc2MTg4MTk5NH0.HAV1Jq0rBOJDlG5WK6sIMxVWmE748RXKeP32xPrTOqM";
        Claims claims = Jwts.parser().setSigningKey("aHVhaWxpemhp")
                .parseClaimsJws(token)
                .getBody();

        System.out.println(claims);
    }
}
