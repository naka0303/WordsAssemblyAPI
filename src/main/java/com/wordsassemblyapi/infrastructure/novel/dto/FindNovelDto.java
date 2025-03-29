package com.wordsassemblyapi.infrastructure.novel.dto;

import com.wordsassemblyapi.domain.novel.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindNovelDto {
  private Integer id;
  private Integer authorId;
  private String title;
  private String category;
  private String digest;
  private String contents;
  private String isPublish;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  /** コンストラクター */
  public FindNovelDto(
      Integer id,
      Integer authorId,
      String title,
      String category,
      String digest,
      String contents,
      String isPublish,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.authorId = authorId;
    this.title = title;
    this.category = category;
    this.digest = digest;
    this.contents = contents;
    this.isPublish = isPublish;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
