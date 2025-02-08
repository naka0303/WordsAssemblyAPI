package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterNovelDto {
  private String title;
  private Integer authorId;
  private String contents;
  private Boolean isPublish;

  /** コンストラクター */
  public RegisterNovelDto(
      String title,
      Integer authorId,
      String contents,
      Boolean isPublish) {
    this.title = title;
    this.authorId = authorId;
    this.contents = contents;
    this.isPublish = isPublish;
  }
}
