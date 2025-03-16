package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterNovelDto {
  private Integer authorId;
  private String title;
  private String digest;
  private String contents;
  private String isPublish;

  /** コンストラクター */
  public RegisterNovelDto(
      Integer authorId,
      String title,
      String digest,
      String contents,
      String isPublish) {
    this.authorId = authorId;
    this.title = title;
    this.digest = digest;
    this.contents = contents;
    this.isPublish = isPublish;
  }
}
