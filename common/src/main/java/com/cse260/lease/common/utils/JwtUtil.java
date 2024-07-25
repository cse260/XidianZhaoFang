package com.cse260.lease.common.utils;

import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private static SecretKey secretKey = Keys.hmacShaKeyFor("MqQb^nznO$#W9oORU!E5Wijc3YLVS1Fn".getBytes());

    public static String createToken(Long userId,String username){
        String jwt = Jwts.builder().
                setExpiration(new Date(System.currentTimeMillis() + 360000*100)).
                setSubject("LOGIN_USER").
                claim("userId", userId).
                claim("username", username).
                signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        return jwt;

    }

    public static Claims parseToken(String token){
        if(token==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        try{
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            return claimsJws.getBody();
        }catch(ExpiredJwtException e){
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        }catch (JwtException e){
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }
    public static void main(String[] args) {
        System.out.println(createToken(9L,"18201127922"));
        System.out.println(createToken(10L,"18201127922"));
        System.out.println(createToken(11L,"18201127922"));
        System.out.println(createToken(12L,"18201127922"));
        System.out.println(createToken(13L,"18201127922"));
        System.out.println(createToken(14L,"18201127922"));
        System.out.println(createToken(15L,"18201127922"));
        System.out.println(createToken(16L,"18201127922"));
        System.out.println(createToken(17L,"18201127922"));

    }
}
