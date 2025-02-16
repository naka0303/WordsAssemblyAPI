package com.wordsassemblyapi.application.login.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class LoginCommandService {

  private final String SECRET_KEY = "AHDUHID58464";

  public LoginCommandService() {

  }

  /**
   * トークン生成
   * @param email メールアドレス
   * @return トークン
   */
  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
  }
}
