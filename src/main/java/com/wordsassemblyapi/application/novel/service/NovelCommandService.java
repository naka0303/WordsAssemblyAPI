package com.wordsassemblyapi.application.novel.service;

import com.wordsassemblyapi.domain.novel.enums.Category;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;
import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.infrastructure.novel.repository.NovelCommandRepository;
import com.wordsassemblyapi.infrastructure.novel.repository.NovelQueryRepository;
import com.wordsassemblyapi.presentation.novel.dto.RegisterNovelRequest;
import org.springframework.stereotype.Service;

@Service
public class NovelCommandService {

  private final NovelCommandRepository novelCommandRepository;

  private final NovelQueryRepository novelQueryRepository;

  public NovelCommandService(
      NovelCommandRepository novelCommandRepository,
      NovelQueryRepository novelQueryRepository) {
    this.novelCommandRepository = novelCommandRepository;
    this.novelQueryRepository = novelQueryRepository;
  }

  /**
   * 小説を新規作成
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  public void registerNovel(RegisterNovelRequest request) throws Exception {

    RegisterNovelDto dto = new RegisterNovelDto(
        request.getAuthorId(),
        Category.getEnum(request.getCategory()),
        request.getTitle(),
        request.getDigest(),
        request.getContents(),
        request.getIsPublish());

    novelCommandRepository.registerNovel(dto);
  }

  /**
   * 指定された小説の削除
   * @param novelId 小説ID
   */
  public void deleteNovelById(Integer novelId) throws Exception {
    FindNovelDto dto = novelQueryRepository.findNovelById(novelId);
    if (dto == null) {
      throw new Exception("Specified.novel.not.found");
    }

    novelCommandRepository.deleteNovelById(novelId);
  }
}
