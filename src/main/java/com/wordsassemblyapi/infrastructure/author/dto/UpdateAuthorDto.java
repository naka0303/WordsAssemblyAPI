package com.wordsassemblyapi.infrastructure.author.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAuthorDto {
  private String firstName;
  private String lastName;
  private String firstNameKana;
  private String lastNameKana;
  private String nickname;
  private Integer age;
  private String selfIntroduction;

  /** コンストラクター */
  public UpdateAuthorDto(
      String firstName,
      String lastName,
      String firstNameKana,
      String lastNameKana,
      String nickname,
      Integer age,
      String selfIntroduction) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstNameKana = firstNameKana;
    this.lastNameKana = lastNameKana;
    this.nickname = nickname;
    this.age = age;
    this.selfIntroduction = selfIntroduction;
  }
}
