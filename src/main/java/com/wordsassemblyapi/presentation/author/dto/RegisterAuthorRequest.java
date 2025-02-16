package com.wordsassemblyapi.presentation.author.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAuthorRequest {

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;

  @NonNull
  private String firstNameKana;

  @NonNull
  private String lastNameKana;

  @NonNull
  private String nickname;

  @NonNull
  private Integer age;

  @NonNull
  private String email;

  @NonNull
  private String password;
}
