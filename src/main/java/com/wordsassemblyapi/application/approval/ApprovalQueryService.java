package com.wordsassemblyapi.application.approval;

import com.wordsassemblyapi.domain.approvals.entity.Approval;
import com.wordsassemblyapi.infrastructure.approval.dto.FindApprovalDto;
import com.wordsassemblyapi.infrastructure.approval.repository.ApprovalQueryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalQueryService {

  private final ApprovalQueryRepository approvalQueryRepository;

  public ApprovalQueryService(
      ApprovalQueryRepository approvalQueryRepository) {
    this.approvalQueryRepository = approvalQueryRepository;
  }

  /**
   * 指定された小説のいいね！情報を全取得.
   * @param novelId 小説ID
   * @return いいね！エンティティリスト
   */
  public List<Approval> findApprovalsById(Integer novelId) {
    List<FindApprovalDto> dto = approvalQueryRepository.findApprovalsById(novelId);

    FindApprovalResource resource = new FindApprovalResource();
    return resource.toEntityList(dto);
  }
}
