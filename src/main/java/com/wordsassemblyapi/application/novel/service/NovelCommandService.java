package com.wordsassemblyapi.application.novel.service;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.infrastructure.novel.repository.NovelCommandRepository;
import com.wordsassemblyapi.presentation.novel.dto.RegisterNovelRequest;
import org.springframework.stereotype.Service;

@Service
public class NovelCommandService {

  private final NovelCommandRepository novelCommandRepository;

  public NovelCommandService(NovelCommandRepository novelCommandRepository) {
    this.novelCommandRepository = novelCommandRepository;
  }

  /**
   * 小説を新規作成
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  public void registerNovel(RegisterNovelRequest request) throws Exception {

    RegisterNovelDto dto = new RegisterNovelDto(
        request.getTitle(),
        request.getAuthorId(),
        request.getContents(),
        request.getIsPublish());

    novelCommandRepository.registerNovel(dto);
  }
}
