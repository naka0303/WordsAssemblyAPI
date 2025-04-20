package com.wordsassemblyapi.infrastructure.approval.repository;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterApprovalDto;
import com.wordsassemblyapi.mapper.approval.ApprovalCommandMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalCommandRepository {

  private final ApprovalCommandMapper approvalCommandMapper;

  public ApprovalCommandRepository(
      ApprovalCommandMapper approvalCommandMapper) {
    this.approvalCommandMapper = approvalCommandMapper;
  }

  /**
   * 小説へのいいね！の登録
   * @param novelId 小説ID
   * @param dto 登録情報
   */
  public void registerApproval(Integer novelId, RegisterApprovalDto dto) throws Exception {
    final int cnt = approvalCommandMapper.insertApproval(novelId, dto);
    if (cnt != 1) {
      throw new Exception("failed to insert approval");
    }
  }
}
