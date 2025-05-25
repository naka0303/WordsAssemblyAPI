package com.wordsassemblyapi.infrastructure.author.repository;

import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorData;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
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
   * 指定メールアドレスの著者の詳細情報取得
   * @param email メールアドレス
   * @return 著者情報
   */
  public FindAuthorDto findAuthorByEmail(String email) {
    FindAuthorData data = authorQueryMapper.selectAuthorByEmail(email);

    if (data == null) {
      return null;
    }

    return new FindAuthorDto(data.getId(), data.getFirstName(), data.getLastName(),
        data.getFirstNameKana(), data.getLastNameKana(), data.getNickname(), data.getAge(),
        data.getEmail(), data.getSelfIntroduction(), data.getCreatedAt(), data.getUpdatedAt(),
        data.getDeletedAt());
  }

  /**
   * 指定IDの著者の詳細情報取得.
   * @param authorId 著者ID
   * @return 著者情報
   */
  public FindAuthorDto findAuthorById(Integer authorId) {
    FindAuthorData data = authorQueryMapper.selectAuthorById(authorId);

    if (data == null) {
      return null;
    }

    return new FindAuthorDto(data.getId(), data.getFirstName(), data.getLastName(),
        data.getFirstNameKana(), data.getLastNameKana(), data.getNickname(), data.getAge(),
        data.getEmail(), data.getSelfIntroduction(), data.getCreatedAt(), data.getUpdatedAt(),
        data.getDeletedAt());
  }

  /**
   * 指定された著者のパスワード情報を取得.
   * @param authorId 著者ID
   * @return パスワード
   */
  public String findPasswordById(Integer authorId) {
    return authorQueryMapper.selectPasswordByAuthor(authorId);
  }
}
