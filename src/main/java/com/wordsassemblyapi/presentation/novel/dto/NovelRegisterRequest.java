package com.wordsassemblyapi.presentation.novel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NovelRegisterRequest {
  private String title;
  private Integer authorId;
  private String contents;
  private Boolean isPublish;
}
