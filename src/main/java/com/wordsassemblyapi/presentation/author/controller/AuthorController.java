package com.wordsassemblyapi.presentation.author.controller;

import com.wordsassemblyapi.presentation.author.dto.RegisterAuthorRequest;
import com.wordsassemblyapi.application.author.service.AuthorCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthorController {

  @Autowired
  private final AuthorCommandService authorCommandService;

  public AuthorController(
      AuthorCommandService authorCommandService) {
    this.authorCommandService = authorCommandService;
  }

  /**
   * 著者の新規登録
   * @param request 登録情報
   */
  @PostMapping("/authors")
  public ResponseEntity<Object> registerAuthor(
      @RequestBody @Validated RegisterAuthorRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    authorCommandService.registerAuthor(request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

}
