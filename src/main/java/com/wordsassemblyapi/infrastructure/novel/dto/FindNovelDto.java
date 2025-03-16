package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindNovelDto {
  private Integer id;
  private String title;
  private Integer authorId;
  private String contents;
  private Boolean isPublish;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  /** コンストラクター */
  public FindNovelDto(
      Integer id,
      String title,
      Integer authorId,
      String contents,
      Boolean isPublish,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.title = title;
    this.authorId = authorId;
    this.contents = contents;
    this.isPublish = isPublish;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
