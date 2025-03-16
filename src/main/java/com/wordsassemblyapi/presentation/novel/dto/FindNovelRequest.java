package com.wordsassemblyapi.presentation.novel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindNovelRequest {

  @NonNull
  private Boolean isPublish;
}
