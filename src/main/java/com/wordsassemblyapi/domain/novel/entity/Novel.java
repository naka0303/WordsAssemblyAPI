package com.wordsassemblyapi.domain.novel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "novels")
public class Novel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  final private Integer id;

  @Column(nullable = false, length = 50)
  final private String title;

  @Column(nullable = false)
  final private Integer authorId;

  @Column(nullable = false, columnDefinition = "TEXT")
  final private String contents;

  @Column(nullable = false)
  final private Boolean isPublish;

  @Column
  final private LocalDateTime createdAt;

  @Column
  final private LocalDateTime updatedAt;

  @Column
  final private LocalDateTime deletedAt;

  /** コンストラクタ */
  public Novel(
      Integer id,
      String title,
      Integer authorId,
      String contents,
      Boolean isPublish,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.title = title;
    this.authorId = authorId;
    this.contents = contents;
    this.isPublish = isPublish;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
