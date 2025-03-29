package com.wordsassemblyapi.presentation.novel.controller;

import com.wordsassemblyapi.application.novel.service.NovelQueryService;
import com.wordsassemblyapi.domain.novel.entity.Novel;
import com.wordsassemblyapi.presentation.novel.dto.FindNovelRequest;
import com.wordsassemblyapi.application.novel.service.NovelCommandService;
import com.wordsassemblyapi.presentation.novel.dto.RegisterNovelRequest;
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
public class NovelController {

  @Autowired
  private final NovelCommandService novelCommandService;

  @Autowired
  private final NovelQueryService novelQueryService;


  public NovelController (
      NovelCommandService novelCommandService,
      NovelQueryService novelQueryService) {
    this.novelCommandService = novelCommandService;
    this.novelQueryService = novelQueryService;
  }

  /**
   * 小説の新規登録
   * @param request 登録情報
   */
  @PostMapping("/v1/novels")
  public ResponseEntity<Object> registerNovel(
      @RequestBody @Validated RegisterNovelRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    novelCommandService.registerNovel(request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

  /**
   * 全ての小説を取得.
   * @param request 検索条件
   */
  @GetMapping("/v1/novels")
  public ResponseEntity<Object> findNovels(
      @ModelAttribute @Validated FindNovelRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    List<Novel> novels = novelQueryService.findNovels(request);

    return ResponseEntity.ok(novels);
  }

  /**
   * 指定された著者に紐づく小説を全取得.
   * @param authorId 著者ID
   * @param request 検索条件
   */
  @GetMapping("/v1/authors/{authorId}/novels")
  public ResponseEntity<Object> findNovelsByAuthor(
      @PathVariable Integer authorId,
      @ModelAttribute @Validated FindNovelRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    List<Novel> novels = novelQueryService.findNovelsByAuthor(authorId, request);

    return ResponseEntity.ok(novels);
  }

  /**
   * 指定された小説を取得.
   * @param novelId 小説ID
   */
  @GetMapping("/v1/novels/{novelId}")
  public ResponseEntity<Object> findNovelsById(
      @PathVariable Integer novelId) {

    Novel novel = novelQueryService.findNovelsById(novelId);

    return ResponseEntity.ok(novel);
  }

  /**
   * 指定された小説の削除
   * @param novelId 小説ID
   */
  @DeleteMapping("/v1/novels/{novelId}")
  public ResponseEntity<Object> deleteNovelById(
      @PathVariable Integer novelId) throws Exception {

    novelCommandService.deleteNovelById(novelId);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

}
