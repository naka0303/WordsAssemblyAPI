package com.wordsassemblyapi.presentation.author.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAuthorRequest {
  private String firstName;
  private String lastName;
  private String firstNameKana;
  private String lastNameKana;
  private String nickname;
  private Integer age;
}
