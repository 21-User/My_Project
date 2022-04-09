package com.fc.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.*;

public class JwtTest {
    @Test
    public void encode1() {
        Map<String, Object> header = new HashMap<>();

        header.put("alg", "HS256");
        header.put("typ" ,"JWT");

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.SECOND, 20);

        String token = JWT
                .create()
                .withHeader(header)
                .withClaim("id" ,1)
                .withClaim("info" ,"令牌")
                .withClaim("createTime", new Date())
                .withExpiresAt(instance.getTime())
                //发布者
                .withIssuer("哈哈哈哈")
                //发布时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("1565356"));

        System.out.println(token);

    }

    @Test
    public void encode() {
        //请求头
        Map<String, Object> header = new HashMap<>();

        header.put("alg", "HS256");
        header.put("typ" ,"JWT");

        //载荷
        HashMap<String, Object> payload = new HashMap<>();

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.MINUTE, 20);

        payload.put("id", 1);
        payload.put("username", "易烊千玺");
        payload.put("info" ,"令牌");
        payload.put("createTime", new Date());
        payload.put("lastAccessTime", new Date());
        payload.put("exp", instance.getTime());

        String token = JWT
                .create()
                .withHeader(header)
                .withPayload(payload)
                .sign(Algorithm.HMAC256("1565356"));

        System.out.println(token);
    }

    @Test
    public void decode() {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("163498")).build();

        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsYXN0QWNjZXNzVGltZSI6MTY0OTI0ODQxMiwiY3JlYXRlVGltZSI6MTY0OTIsImlkIjoxLCJleHAiOjE2NDkyNDk2MTIsInVzZXJuYW1lIjoi5piT54OK5Y2D5466IiwiaW5mbyI6IuS7pOeJjCJ9.K4W14kcT1ZA1R_MG9B18c08vKAaYDA7wZH8WZAwx2EQ");

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getExpiresAt());

        System.out.println(decodedJWT.getClaim("username"));
        System.out.println(decodedJWT.getClaim("createTime"));
        System.out.println(decodedJWT.getClaim("lastAccessTime"));
        System.out.println(decodedJWT.getClaim("info"));
        Map<String, Claim> map = decodedJWT.getClaims();

        Set<Map.Entry<String, Claim>> entries = map.entrySet();

        for (Map.Entry<String, Claim> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
