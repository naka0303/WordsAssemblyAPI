package com.wordsassemblyapi.application.author.service;

import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
import com.wordsassemblyapi.infrastructure.author.repository.AuthorQueryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorQueryService {

  private final AuthorQueryRepository authorQueryRepository;

  public AuthorQueryService(
      AuthorQueryRepository authorQueryRepository) {
    this.authorQueryRepository = authorQueryRepository;
  }

  /**
   * 指定メールアドレスでの著者の詳細情報取得.
   * @param email メールアドレス
   * @return 著者情報
   */
  public Author findAuthorByEmail(String email) {
    FindAuthorDto dto = authorQueryRepository.findAuthorByEmail(email);
    if (dto == null) {
      return null;
    }

    final String password = authorQueryRepository.findPasswordById(dto.getId());

    FindAuthorResource resource = new FindAuthorResource();
    return resource.toEntity(dto, password);
  }

  /**
   * 指定IDでの著者の詳細情報取得.
   * @param authorId 著者ID
   * @return 著者情報
   */
  public Author findAuthorById(Integer authorId) {
    FindAuthorDto dto = authorQueryRepository.findAuthorById(authorId);

    final String password = authorQueryRepository.findPasswordById(dto.getId());

    FindAuthorResource resource = new FindAuthorResource();
    return resource.toEntity(dto, password);
  }
}
