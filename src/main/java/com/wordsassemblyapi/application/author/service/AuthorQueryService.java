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
   * 著者の詳細情報取得.
   *
   * @param email メールアドレス
   * @return 著者情報
   */
  public Author findAuthorByEmail(String email) {
    FindAuthorDto dto = authorQueryRepository.findAuthorByEmail(email);

    FindAuthorResource resource = new FindAuthorResource();
    return resource.toEntity(dto);
  }
}
