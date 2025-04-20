package com.wordsassemblyapi.infrastructure.novel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterApprovalDto {
  private Integer fromAuthorId;
  private Integer toAuthorId;

  /** コンストラクター */
  public RegisterApprovalDto(
      Integer fromAuthorId,
      Integer toAuthorId) {
    this.fromAuthorId = fromAuthorId;
    this.toAuthorId = toAuthorId;
  }
}
