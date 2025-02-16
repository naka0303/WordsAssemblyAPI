package com.wordsassemblyapi.presentation.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

  @NonNull
  private String email;

  @NonNull
  private String password;
}
