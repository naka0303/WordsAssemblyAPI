package com.wordsassemblyapi.infrastructure.novel.repository;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.infrastructure.novel.dto.UpdateNovelDto;
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
    final int cnt = novelCommandMapper.insertNovel(dto);
    if (cnt != 1) {
      throw new Exception("failed to insert novel");
    }
  }

  /**
   * 指定された小説の更新
   * @param novelId 小説ID
   * @param dto 更新DTO
   * @throws Exception 例外処理
   */
  public void updateNovelId(Integer novelId, UpdateNovelDto dto) throws Exception {
    final int cnt = novelCommandMapper.updateNovelById(
        novelId, dto);
    if (cnt != 1) {
      throw new Exception("failed to update novel by id");
    }
  }

  /**
   * 指定された小説の削除
   * @param novelId 小説ID
   * @throws Exception 例外処理
   */
  public void deleteNovelById(Integer novelId) throws Exception {
    final int cnt = novelCommandMapper.deleteNovelById(novelId);
    if (cnt != 1) {
      throw new Exception("failed to delete novel by id");
    }
  }
}
