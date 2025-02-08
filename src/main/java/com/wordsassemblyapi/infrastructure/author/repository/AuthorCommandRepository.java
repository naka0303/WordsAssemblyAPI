package com.wordsassemblyapi.infrastructure.author.repository;

import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import com.wordsassemblyapi.mapper.author.AuthorCommandMapper;
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
    int cnt = authorCommandMapper.insertAuthor(dto);
    if (cnt != 1) {
      throw new Exception("failed to insert author");
    }
  }
}
