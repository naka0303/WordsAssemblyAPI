package com.wordsassemblyapi.presentation.login.controller;

import com.wordsassemblyapi.application.author.service.AuthorQueryService;
import com.wordsassemblyapi.application.login.service.LoginCommandService;
import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.presentation.login.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LoginController {

  @Autowired
  private final LoginCommandService loginCommandService;

  @Autowired
  private final AuthorQueryService authorQueryService;

  public LoginController(
      LoginCommandService loginCommandService,
      AuthorQueryService authorQueryService) {
    this.loginCommandService = loginCommandService;
    this.authorQueryService = authorQueryService;
  }

  /**
   * ログイン
   * @param request ログイン情報
   */
  @PostMapping("/v1/login")
  public ResponseEntity<Object> login(
      @RequestBody @Validated LoginRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    Author author = authorQueryService.findAuthorByEmail(request.getEmail());

    Map<String, String> response = new HashMap<>();

    if (author == null) {
      response.put("message", "user.not.found");
      return ResponseEntity.badRequest().body(response);
    }

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if (!passwordEncoder.matches(request.getPassword(), author.getPassword())) {
      response.put("message", "password.is.not.match");
      return ResponseEntity.badRequest().body(response);
    }

    return ResponseEntity.ok(author);
  }
}
