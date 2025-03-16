package com.wordsassemblyapi.domain.author.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  final private Integer id;

  @Column(nullable = false, length = 10)
  final private String firstName;

  @Column(nullable = false, length = 10)
  final private String lastName;

  @Column(nullable = false, length = 20)
  final private String firstNameKana;

  @Column(nullable = false, length = 20)
  final private String lastNameKana;

  @Column(nullable = false, length = 20)
  final private String nickname;

  @Column
  final private Integer age;

  @Column
  final private String email;

  @Column
  final private String password;

  @Column
  final private LocalDateTime createdAt;

  @Column
  final private LocalDateTime updatedAt;

  @Column
  final private LocalDateTime deletedAt;

  /** コンストラクタ */
  public Author(
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
