package com.wordsassemblyapi.application.author.service;

import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import com.wordsassemblyapi.presentation.author.dto.RegisterAuthorRequest;
import com.wordsassemblyapi.infrastructure.author.repository.AuthorCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorCommandService {

  private final AuthorCommandRepository authorCommandRepository;

  public AuthorCommandService(AuthorCommandRepository authorCommandRepository) {
    this.authorCommandRepository = authorCommandRepository;
  }

  /**
   * 著者を新規登録
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  public void registerAuthor(RegisterAuthorRequest request) throws Exception {

    RegisterAuthorDto dto = new RegisterAuthorDto(
        request.getFirstName(),
        request.getLastName(),
        request.getFirstNameKana(),
        request.getLastNameKana(),
        request.getNickname(),
        request.getAge());

    authorCommandRepository.registerAuthor(dto);
  }
}
