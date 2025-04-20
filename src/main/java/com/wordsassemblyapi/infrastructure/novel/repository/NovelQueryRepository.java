package com.wordsassemblyapi.infrastructure.novel.repository;

import com.wordsassemblyapi.domain.novel.enums.Category;
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
   * 全ての小説を取得.
   * @param request 検索条件
   * @return 小説DTOリスト
   */
  public List<FindNovelDto> findNovels(FindNovelRequest request) {
    List<FindNovelData> dataList =
        novelQueryMapper.selectNovels(request.getIsPublish());

    if (CollectionUtils.isEmpty(dataList)) {
      return null;
    }

    List<FindNovelDto> dtoList = new ArrayList<>();
    for (FindNovelData data : dataList) {
      dtoList.add(new FindNovelDto(
          data.getId(), data.getAuthorId(), data.getNickname(), data.getTitle(), data.getCategory(),
          data.getDigest(), data.getContents(), data.getIsPublish(), data.getCreatedAt(),
          data.getUpdatedAt(), data.getDeletedAt()));
    }
    return dtoList;
  }

  /**
   * 指定された著者に紐づく小説を全取得.
   * @param authorId 著者ID
   * @param request 検索条件
   * @return 小説DTOリスト
   */
  public List<FindNovelDto> findNovelsByAuthor(Integer authorId, FindNovelRequest request) {
    List<FindNovelData> dataList =
        novelQueryMapper.selectNovelsByAuthor(authorId);

    if (CollectionUtils.isEmpty(dataList)) {
      return null;
    }

    List<FindNovelDto> dtoList = new ArrayList<>();
    for (FindNovelData data : dataList) {
      dtoList.add(new FindNovelDto(
          data.getId(), data.getAuthorId(), data.getNickname(), data.getTitle(), data.getCategory(),
          data.getDigest(), data.getContents(), data.getIsPublish(), data.getCreatedAt(),
          data.getUpdatedAt(), data.getDeletedAt()));
    }
    return dtoList;
  }

  /**
   * 指定されたIDの小説を取得.
   * @param novelId 小説ID
   * @return 小説DTO
   */
  public FindNovelDto findNovelById(Integer novelId) {
    FindNovelData data = novelQueryMapper.selectNovelById(novelId);

    if (data == null) {
      return null;
    }

    return new FindNovelDto(
        data.getId(), data.getAuthorId(), data.getNickname(), data.getTitle(), data.getCategory(),
        data.getDigest(), data.getContents(), data.getIsPublish(), data.getCreatedAt(),
        data.getUpdatedAt(), data.getDeletedAt());
  }
}
