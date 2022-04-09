package com.fc.test;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtUtilTest {
    @Test
    public void testCreate() {
        HashMap<String, Object> claim = new HashMap<>();

        claim.put("id", "1");
        claim.put("username", "易烊千玺");

        String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 20);

        System.out.println(token);

    }

    @Test
    //获取token中的载荷
    public void testParse() {
        Map<String, Object> map = JwtUtil.getClaim("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbSI6eyJpZCI6IjEiLCJ1c2VybmFtZSI6IuaYk-eDiuWNg-eOuiJ9LCJleHAiOjE2NDkyNDkzMjl9.WNGsfovPCujwJFlprdTIiA5s0ULb5EkdrZEJ0CKVT54");

        Set<Map.Entry<String, Object>> entrySet = map.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


}
