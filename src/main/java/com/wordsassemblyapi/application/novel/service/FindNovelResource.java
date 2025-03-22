package com.wordsassemblyapi.application.novel.service;

import com.wordsassemblyapi.domain.novel.entity.Novel;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class FindNovelResource {

  /**
   * DTOList -> EntityList変換.
   * @param dtoList 小説DTOリスト
   * @return 小説エンティティリスト
   */
  public List<Novel> toEntityList(List<FindNovelDto> dtoList) {
    if (CollectionUtils.isEmpty(dtoList)) {
      return null;
    }

    List<Novel> novels = new ArrayList<>();
    for (FindNovelDto dto : dtoList) {
      novels.add(new Novel(
          dto.getId(),
          dto.getAuthorId(),
          dto.getTitle(),
          dto.getDigest(),
          dto.getContents(),
          dto.getIsPublish(),
          dto.getCreatedAt(),
          dto.getUpdatedAt(),
          dto.getDeletedAt()
      ));
    }

    return novels;
  }

  /**
   * DTO -> Entity変換.
   * @param dto 小説DTO
   * @return 小説エンティティ
   */
  public Novel toEntity(FindNovelDto dto) {
    if (dto == null) {
      return null;
    }

    return new Novel(
        dto.getId(),
        dto.getAuthorId(),
        dto.getTitle(),
        dto.getDigest(),
        dto.getContents(),
        dto.getIsPublish(),
        dto.getCreatedAt(),
        dto.getUpdatedAt(),
        dto.getDeletedAt()
    );
  }
}
