package com.wordsassemblyapi.infrastructure.novel.dto;

import com.wordsassemblyapi.domain.novel.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class RegisterNovelDto {
  private Integer authorId;
  private Category category;
  private String title;
  private String digest;
  private String contents;
  private String isPublish;

  /** コンストラクター */
  public RegisterNovelDto(
      Integer authorId,
      Category category,
      String title,
      String digest,
      String contents,
      String isPublish) {
    this.authorId = authorId;
    this.category = category;
    this.title = title;
    this.digest = digest;
    this.contents = contents;
    this.isPublish = isPublish;
  }
}
