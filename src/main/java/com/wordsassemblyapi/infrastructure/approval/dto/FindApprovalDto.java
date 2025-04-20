package com.wordsassemblyapi.infrastructure.approval.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindApprovalDto {
  private Integer id;
  private Integer novelId;
  private Integer fromAuthorId;
  private Integer toAuthorId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  /** コンストラクター */
  public FindApprovalDto(
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
