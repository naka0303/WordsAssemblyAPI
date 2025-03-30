package com.wordsassemblyapi.infrastructure.novel.dto;

import com.wordsassemblyapi.domain.novel.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNovelDto {
  private String title;
  private Category category;
  private String digest;
  private String contents;
  private String isPublish;

  /** コンストラクター */
  public UpdateNovelDto(
      String title,
      Category category,
      String digest,
      String contents,
      String isPublish) {
    this.title = title;
    this.category = category;
    this.digest = digest;
    this.contents = contents;
    this.isPublish = isPublish;
  }
}
