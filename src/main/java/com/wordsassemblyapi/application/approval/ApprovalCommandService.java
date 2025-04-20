package com.wordsassemblyapi.application.approval;

import com.wordsassemblyapi.infrastructure.approval.repository.ApprovalCommandRepository;
import com.wordsassemblyapi.infrastructure.novel.dto.RegisterApprovalDto;
import com.wordsassemblyapi.presentation.novel.dto.RegisterApprovalRequest;
import org.springframework.stereotype.Service;

@Service
public class ApprovalCommandService {

  private final ApprovalCommandRepository approvalCommandRepository;

  public ApprovalCommandService(
      ApprovalCommandRepository approvalCommandRepository) {
    this.approvalCommandRepository = approvalCommandRepository;
  }

  /**
   * 小説へのいいね！の登録
   * @param novelId 小説ID
   * @param request 登録情報
   */
  public void registerApproval(Integer novelId, RegisterApprovalRequest request) throws Exception {

    RegisterApprovalDto dto = new RegisterApprovalDto(
        request.getFromAuthorId(),
        request.getToAuthorId());

    approvalCommandRepository.registerApproval(novelId, dto);
  }
}
