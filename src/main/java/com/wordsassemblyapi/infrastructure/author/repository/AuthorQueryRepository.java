package com.wordsassemblyapi.infrastructure.author.repository;

import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorData;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import com.wordsassemblyapi.mapper.author.AuthorCommandMapper;
import com.wordsassemblyapi.mapper.author.AuthorQueryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorQueryRepository {

  private final AuthorQueryMapper authorQueryMapper;

  public AuthorQueryRepository(
      AuthorQueryMapper authorQueryMapper) {
    this.authorQueryMapper = authorQueryMapper;
  }

  /**
   * 著者の詳細情報取得
   *
   * @param email メールアドレス
   * @return 著者情報
   */
  public FindAuthorDto findAuthorByEmail(String email) {
    FindAuthorData data = authorQueryMapper.selectAuthorByEmail(email);

    if (data == null) {
      return null;
    }

    return new FindAuthorDto(data.getFirstName(), data.getLastName(), data.getFirstNameKana(),
        data.getLastNameKana(), data.getNickname(), data.getAge(), data.getEmail(), data.getPassword(),
        data.getCreatedAt(), data.getUpdatedAt(), data.getDeletedAt());
  }
}
