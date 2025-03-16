package com.wordsassemblyapi.application.novel.service;

import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.domain.novel.entity.Novel;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;

import java.util.ArrayList;
import java.util.List;

public class FindNovelResource {

  /**
   * DTOList -> EntityList変換.
   * @param dtoList 小説DTOリスト
   * @return 小説エンティティリスト
   */
  public List<Novel> toEntityList(List<FindNovelDto> dtoList) {
    if (dtoList.isEmpty()) {
      return null;
    }

    List<Novel> novels = new ArrayList<>();
    for (FindNovelDto dto : dtoList) {
      novels.add(
       new Novel(
           dto.getId(),
           dto.getTitle(),
           dto.getAuthorId(),
           dto.getContents(),
           dto.getIsPublish(),
           dto.getCreatedAt(),
           dto.getUpdatedAt(),
           dto.getDeletedAt()
       ));
    }

    return novels;
  }

}
