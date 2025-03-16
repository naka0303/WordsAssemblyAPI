package com.wordsassemblyapi.infrastructure.novel.repository;

import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelData;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;
import com.wordsassemblyapi.mapper.novel.NovelQueryMapper;
import com.wordsassemblyapi.presentation.novel.dto.FindNovelRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NovelQueryRepository {

  private final NovelQueryMapper novelQueryMapper;

  public NovelQueryRepository(
      NovelQueryMapper novelQueryMapper) {
    this.novelQueryMapper = novelQueryMapper;
  }

  /**
   * 指定された著者に紐づく小説を全取得.
   * @param authorId 著者ID
   * @param request 検索条件
   */
  public List<FindNovelDto> findNovelsByAuthor(Integer authorId, FindNovelRequest request) {
    List<FindNovelData> dataList =
        novelQueryMapper.selectNovelsByAuthor(authorId, request.getIsPublish());

    if (CollectionUtils.isEmpty(dataList)) {
      return null;
    }

    List<FindNovelDto> dtoList = new ArrayList<>();
    for (FindNovelData data : dataList) {
      dtoList.add(new FindNovelDto(
          data.getId(), data.getTitle(), data.getAuthorId(), data.getContents(),
          data.getIsPublish(), data.getCreatedAt(), data.getUpdatedAt(), data.getDeletedAt()));
    }
    return dtoList;
  }
}
