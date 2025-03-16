package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindNovelData {
  private Integer id;
  private String title;
  private Integer authorId;
  private String contents;
  private Boolean isPublish;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
}
