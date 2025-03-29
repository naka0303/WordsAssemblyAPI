package com.wordsassemblyapi.domain.novel.entity;

import com.wordsassemblyapi.domain.novel.enums.Category;
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

  @Column(nullable = false)
  final private Integer authorId;

  @Column(nullable = false, length = 50)
  final private String title;

  @Column(nullable = false, length = 50)
  final private String category;

  @Column(nullable = false, length = 50)
  final private String digest;

  @Column(nullable = false, columnDefinition = "TEXT")
  final private String contents;

  @Column(nullable = false)
  final private String isPublish;

  @Column
  final private LocalDateTime createdAt;

  @Column
  final private LocalDateTime updatedAt;

  @Column
  final private LocalDateTime deletedAt;

  /** コンストラクタ */
  public Novel(
      Integer id,
      Integer authorId,
      String title,
      String category,
      String digest,
      String contents,
      String isPublish,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.authorId = authorId;
    this.title = title;
    this.category = category;
    this.digest = digest;
    this.contents = contents;
    this.isPublish = isPublish;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
