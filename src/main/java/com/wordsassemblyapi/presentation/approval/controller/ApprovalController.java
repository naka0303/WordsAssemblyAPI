package com.wordsassemblyapi.presentation.approval.controller;

import com.wordsassemblyapi.application.approval.ApprovalCommandService;
import com.wordsassemblyapi.application.approval.ApprovalQueryService;
import com.wordsassemblyapi.domain.approvals.entity.Approval;
import com.wordsassemblyapi.presentation.novel.dto.RegisterApprovalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ApprovalController {

  @Autowired
  private final ApprovalCommandService approvalCommandService;

  @Autowired
  private final ApprovalQueryService approvalQueryService;


  public ApprovalController(
      ApprovalCommandService approvalCommandService,
      ApprovalQueryService approvalQueryService) {
    this.approvalCommandService = approvalCommandService;
    this.approvalQueryService = approvalQueryService;
  }

  /**
   * 小説へのいいね！の登録
   * @param novelId 小説ID
   * @param request 登録情報
   */
  @PostMapping("/v1/novels/{novelId}/approval")
  public ResponseEntity<Object> registerApproval(
      @PathVariable Integer novelId,
      @RequestBody @Validated RegisterApprovalRequest request,
      Errors errors) throws Exception {

    if (errors.hasErrors()) {
      throw new Exception("Invalid Request");
    }

    approvalCommandService.registerApproval(novelId, request);

    return ResponseEntity.status(HttpStatus.OK).body(Objects.class);
  }

  /**
   * 指定された小説のいいね！情報を全取得.
   * @param novelId 小説ID
   * @return いいね！情報
   */
  @GetMapping("/v1/novels/{novelId}/approvals")
  public ResponseEntity<Object> findApprovalsById(
      @PathVariable Integer novelId) {

    List<Approval> approvals = approvalQueryService.findApprovalsById(novelId);

    return ResponseEntity.ok(approvals);
  }
}
