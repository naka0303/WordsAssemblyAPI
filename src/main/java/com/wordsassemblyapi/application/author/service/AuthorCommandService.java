package com.wordsassemblyapi.application.author.service;

import com.wordsassemblyapi.domain.author.entity.Author;
import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import com.wordsassemblyapi.infrastructure.author.dto.UpdateAuthorDto;
import com.wordsassemblyapi.presentation.author.dto.RegisterAuthorRequest;
import com.wordsassemblyapi.infrastructure.author.repository.AuthorCommandRepository;
import com.wordsassemblyapi.presentation.author.dto.UpdateAuthorRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorCommandService {

  private final AuthorCommandRepository authorCommandRepository;
  private final AuthorQueryService authorQueryService;

  public AuthorCommandService(
      AuthorCommandRepository authorCommandRepository,
      AuthorQueryService authorQueryService) {
    this.authorCommandRepository = authorCommandRepository;
    this.authorQueryService = authorQueryService;
  }

  /**
   * 著者を新規登録.
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  public void registerAuthor(RegisterAuthorRequest request) throws Exception {

    // パスワード暗号化
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    final String digest = passwordEncoder.encode(request.getPassword());
    
    RegisterAuthorDto dto = new RegisterAuthorDto(
        request.getFirstName(),
        request.getLastName(),
        request.getFirstNameKana(),
        request.getLastNameKana(),
        request.getNickname(),
        request.getAge(),
        request.getEmail(),
        digest);

    authorCommandRepository.registerAuthor(dto);
  }

  /**
   * 著者を更新.
   * @param authorId 著者ID
   * @param request 更新情報
   */
  public void updateAuthorById(Integer authorId, UpdateAuthorRequest request) throws Exception {

    final Author author = authorQueryService.findAuthorById(authorId);
    if (author == null) {
      throw new Exception("Specified.author.not.found");
    }

    UpdateAuthorDto dto = new UpdateAuthorDto(
        request.getFirstName(),
        request.getLastName(),
        request.getFirstNameKana(),
        request.getLastNameKana(),
        request.getNickname(),
        request.getAge(),
        request.getSelfIntroduction());

    authorCommandRepository.updateAuthorById(authorId, dto);
  }
}
