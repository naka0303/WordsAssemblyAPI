package com.wordsassemblyapi.presentation.author.controller;

import com.wordsassemblyapi.application.author.service.AuthorQueryService;
import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.domain.novel.entity.Novel;
import com.wordsassemblyapi.presentation.author.dto.RegisterAuthorRequest;
import com.wordsassemblyapi.application.author.service.AuthorCommandService;
import com.wordsassemblyapi.presentation.author.dto.UpdateAuthorRequest;
import com.wordsassemblyapi.presentation.novel.dto.FindNovelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AuthorController {

  @Autowired
  private final AuthorCommandService authorCommandService;

  @Autowired
  private final AuthorQueryService authorQueryService;

  public AuthorController(
      AuthorCommandService authorCommandService,
      AuthorQueryService authorQueryService) {
    this.authorCommandService = authorCommandService;
    this.authorQueryService = authorQueryService;
  }

  /**
   * 著者情報の取得
   */
  @GetMapping("/v1/authors/{authorId}")
  public ResponseEntity<Object> findAuthorById (
    @PathVariable Integer authorId) {

    Author author = authorQueryService.findAuthorById(authorId);

    return ResponseEntity.ok(author);
  }

  /**
   * 著者の新規登録
   * @param request 登録情報
   */
  @PostMapping("/v1/authors")
  public ResponseEntity<Object> registerAuthor(
      @RequestBody @Validated RegisterAuthorRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    authorCommandService.registerAuthor(request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

  /**
   * 著者情報の更新
   * @param authorId 著者ID
   * @param request 更新情報
   * @throws Exception 例外処理
   */
  @PutMapping("/v1/authors/{authorId}")
  public ResponseEntity<Object> updateAuthorById(
      @PathVariable Integer authorId,
      @RequestBody @Validated UpdateAuthorRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    authorCommandService.updateAuthorById(authorId, request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }


}
