package com.wordsassemblyapi.presentation.login.controller;

import com.wordsassemblyapi.application.author.service.AuthorQueryService;
import com.wordsassemblyapi.application.login.service.LoginCommandService;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
import com.wordsassemblyapi.presentation.login.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    FindAuthorDto dto = authorQueryService.findAuthorByEmail(request.getEmail());

    if (dto == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    if (!passwordEncoder.matches(request.getPassword(), dto.getPassword())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
