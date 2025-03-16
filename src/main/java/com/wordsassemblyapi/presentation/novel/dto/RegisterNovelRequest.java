package com.wordsassemblyapi.presentation.novel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterNovelRequest {
  private Integer authorId;
  private String title;
  private String contents;
  private Boolean isPublish;
}
