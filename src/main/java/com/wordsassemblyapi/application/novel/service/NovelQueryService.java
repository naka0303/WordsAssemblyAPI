package com.wordsassemblyapi.application.novel.service;

import com.wordsassemblyapi.application.author.service.FindAuthorResource;
import com.wordsassemblyapi.domain.novel.entity.Novel;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;
import com.wordsassemblyapi.infrastructure.novel.repository.NovelQueryRepository;
import com.wordsassemblyapi.presentation.novel.dto.FindNovelRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NovelQueryService {

  private final NovelQueryRepository novelQueryRepository;

  public NovelQueryService(
      NovelQueryRepository novelQueryRepository) {
    this.novelQueryRepository = novelQueryRepository;
  }

  /**
   * 全ての小説を取得.
   * @param request 検索条件
   * @return 小説エンティティリスト
   */
  public List<Novel> findNovels(FindNovelRequest request) {
    List<FindNovelDto> dtoList = novelQueryRepository.findNovels(request);

    FindNovelResource resource = new FindNovelResource();
    return resource.toEntityList(dtoList);
  }

  /**
   * 指定された著者に紐づく小説を全取得.
   * @param authorId 著者ID
   * @param request 検索条件
   * @return 小説エンティティリスト
   */
  public List<Novel> findNovelsByAuthor(Integer authorId, FindNovelRequest request) {
    List<FindNovelDto> dtoList = novelQueryRepository.findNovelsByAuthor(authorId, request);

    FindNovelResource resource = new FindNovelResource();
    return resource.toEntityList(dtoList);
  }

  /**
   * 指定されたIDの小説を取得.
   * @param novelId 小説ID
   * @return 小説エンティティ
   */
  public Novel findNovelsById(Integer novelId) {
    FindNovelDto dto = novelQueryRepository.findNovelById(novelId);

    FindNovelResource resource = new FindNovelResource();
    return resource.toEntity(dto);
  }
}
