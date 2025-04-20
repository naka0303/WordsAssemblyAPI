package com.wordsassemblyapi.domain.approvals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "approvals")
public class Approval {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  final private Integer id;

  @Column(nullable = false)
  final private Integer novelId;

  @Column(nullable = false)
  final private Integer fromAuthorId;

  @Column(nullable = false)
  final private Integer toAuthorId;

  @Column
  final private LocalDateTime createdAt;

  @Column
  final private LocalDateTime updatedAt;

  @Column
  final private LocalDateTime deletedAt;

  /** コンストラクタ */
  public Approval(
      Integer id,
      Integer novelId,
      Integer fromAuthorId,
      Integer toAuthorId,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      LocalDateTime deletedAt) {
    this.id = id;
    this.novelId = novelId;
    this.fromAuthorId = fromAuthorId;
    this.toAuthorId = toAuthorId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}
