package com.wordsassemblyapi.infrastructure.author.repository;

import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import com.wordsassemblyapi.infrastructure.author.dto.UpdateAuthorDto;
import com.wordsassemblyapi.mapper.author.AuthorCommandMapper;
import com.wordsassemblyapi.presentation.author.dto.UpdateAuthorRequest;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorCommandRepository {

  private final AuthorCommandMapper authorCommandMapper;

  public AuthorCommandRepository(
      AuthorCommandMapper authorCommandMapper) {
    this.authorCommandMapper = authorCommandMapper;
  }

  /**
   * 著者の新規登録
   * @param dto 登録DTO
   * @throws Exception 例外処理
   */
  public void registerAuthor(RegisterAuthorDto dto) throws Exception {
    final int cnt = authorCommandMapper.insertAuthor(dto);
    if (cnt != 1) {
      throw new Exception("failed to insert author");
    }
  }

  /**
   * 著者を更新
   * @param authorId 著者ID
   * @param dto 更新DTO
   * @throws Exception 例外処理
   */
  public void updateAuthorById(Integer authorId, UpdateAuthorDto dto) throws Exception {
    final int cnt = authorCommandMapper.updateAuthorById(
        authorId, dto);
    if (cnt != 1) {
      throw new Exception("failed to update author by id");
    }
  }
}
