package com.wordsassemblyapi.presentation.novel.dto;

import lombok.*;

@Getter
@Setter
public class FindNovelRequest {

  @NonNull
  private String isPublish;
}
