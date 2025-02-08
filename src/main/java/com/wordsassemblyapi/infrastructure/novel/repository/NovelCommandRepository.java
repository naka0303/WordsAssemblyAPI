package com.wordsassemblyapi.infrastructure.novel.repository;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.mapper.novel.NovelCommandMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NovelCommandRepository {

  private final NovelCommandMapper novelCommandMapper;

  public NovelCommandRepository(
      NovelCommandMapper novelCommandMapper) {
    this.novelCommandMapper = novelCommandMapper;
  }

  /**
   * 小説の新規登録
   * @param dto 登録DTO
   * @throws Exception 例外処理
   */
  public void registerNovel(RegisterNovelDto dto) throws Exception {
    int cnt = novelCommandMapper.insertNovel(dto);
    if (cnt != 1) {
      throw new Exception("failed to insert novel");
    }
  }
}
