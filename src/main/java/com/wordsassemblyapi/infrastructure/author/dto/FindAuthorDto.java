package com.wordsassemblyapi.infrastructure.author.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindAuthorDto {
  private Integer id;
  private String firstName;
  private String lastName;
  private String firstNameKana;
  private String lastNameKana;
  private String nickname;
  private Integer age;
  private String email;
  private String password;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  /** コンストラクター */
  public FindAuthorDto(
      Integer id,
      String firstName,
      String lastName,
      String firstNameKana,
      String lastNameKana,
      String nickname,
      Integer age,
      String email,
      String password,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstNameKana = firstNameKana;
    this.lastNameKana = lastNameKana;
    this.nickname = nickname;
    this.age = age;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
