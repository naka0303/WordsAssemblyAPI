package com.wordsassemblyapi.infrastructure.author.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindAuthorData {
  private Integer id;
  private String firstName;
  private String lastName;
  private String firstNameKana;
  private String lastNameKana;
  private String nickname;
  private Integer age;
  private String email;
  private String selfIntroduction;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
}
