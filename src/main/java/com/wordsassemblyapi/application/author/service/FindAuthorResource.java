package com.wordsassemblyapi.application.author.service;

import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;

public class FindAuthorResource {

  /**
   * DTO -> Entity変換.
   * @param dto 著者DTO
   * @param password パスワード
   * @return 著者エンティティ
   */
  public Author toEntity(FindAuthorDto dto, String password) {
    if (dto == null) {
      return null;
    }

    return new Author(
        dto.getId(),
        dto.getFirstName(),
        dto.getLastName(),
        dto.getFirstNameKana(),
        dto.getLastNameKana(),
        dto.getNickname(),
        dto.getAge(),
        dto.getEmail(),
        password,
        dto.getSelfIntroduction(),
        dto.getCreatedAt(),
        dto.getUpdatedAt(),
        dto.getDeletedAt()
    );
  }

}
