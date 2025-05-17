package com.wordsassemblyapi.application.approval;

import com.wordsassemblyapi.domain.approvals.entity.Approval;
import com.wordsassemblyapi.infrastructure.approval.repository.ApprovalCommandRepository;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
import com.wordsassemblyapi.infrastructure.author.repository.AuthorQueryRepository;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelDto;
import com.wordsassemblyapi.infrastructure.novel.dto.RegisterApprovalDto;
import com.wordsassemblyapi.infrastructure.novel.repository.NovelQueryRepository;
import com.wordsassemblyapi.presentation.novel.dto.RegisterApprovalRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalCommandService {

  private final ApprovalCommandRepository approvalCommandRepository;
  private final ApprovalQueryService approvalQueryService;
  private final NovelQueryRepository novelQueryRepository;
  private final AuthorQueryRepository authorQueryRepository;

  public ApprovalCommandService(
      ApprovalCommandRepository approvalCommandRepository,
      NovelQueryRepository novelQueryRepository,
      AuthorQueryRepository authorQueryRepository,
      ApprovalQueryService approvalQueryService) {
    this.approvalCommandRepository = approvalCommandRepository;
    this.novelQueryRepository = novelQueryRepository;
    this.authorQueryRepository = authorQueryRepository;
    this.approvalQueryService = approvalQueryService;
  }

  /**
   * 小説へのいいね！の登録.
   * @param novelId 小説ID
   * @param request 登録情報
   */
  public void registerApproval(Integer novelId, RegisterApprovalRequest request) throws Exception {

    RegisterApprovalDto dto = new RegisterApprovalDto(
        request.getFromAuthorId(),
        request.getToAuthorId());

    approvalCommandRepository.registerApproval(novelId, dto);
  }

  /**
   * 指定された小説の、指定された著者からのいいね！を削除.
   * @param novelId 小説ID
   * @param authorId 著者ID
   */
  public void deleteApprovalByAuthor(Integer novelId, Integer authorId) throws Exception {

    List<Approval> approvals = approvalQueryService.findApprovalsById(novelId);

    List<Approval> approvalsFiltered =
        approvals.stream().filter(x -> x.getFromAuthorId().equals(authorId)).toList();
    if (approvalsFiltered.isEmpty()) {
      return;
    }

    approvalCommandRepository.deleteApprovalByAuthor(novelId, authorId);
  }
}
