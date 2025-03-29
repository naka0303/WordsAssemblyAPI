package com.wordsassemblyapi.presentation.novel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterNovelRequest {
  private Integer authorId;
  private String category;
  private String title;
  private String digest;
  private String contents;

  /**
   * 投稿されているかどうか
   * true: 投稿済み false: 下書き保存
   */
  private String isPublish;
}
