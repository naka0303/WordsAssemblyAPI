package com.wordsassemblyapi.infrastructure.approval.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindApprovalData {
  private Integer id;
  private Integer novelId;
  private Integer fromAuthorId;
  private Integer toAuthorId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
}
