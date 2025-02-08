package com.wordsassemblyapi.presentation.novel.controller;

import com.wordsassemblyapi.presentation.novel.dto.NovelRegisterRequest;
import com.wordsassemblyapi.application.novel.service.NovelCommandService;
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
public class NovelController {

  @Autowired
  private final NovelCommandService novelCommandService;

  public NovelController (
      NovelCommandService novelCommandService) {
    this.novelCommandService = novelCommandService;
  }

  /**
   * 小説の新規登録
   * @param request 登録情報
   */
  @PostMapping("/novels")
  public ResponseEntity<Object> registerNovel(
      @RequestBody @Validated NovelRegisterRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    novelCommandService.registerNovel(request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

}
