package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindNovelData {
  private Integer id;
  private Integer authorId;
  private String nickname;
  private String title;
  private String category;
  private String digest;
  private String contents;
  private String isPublish;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
}
