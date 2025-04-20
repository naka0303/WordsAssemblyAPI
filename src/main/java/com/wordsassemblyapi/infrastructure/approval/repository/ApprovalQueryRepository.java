package com.wordsassemblyapi.infrastructure.approval.repository;

import com.wordsassemblyapi.infrastructure.approval.dto.FindApprovalData;
import com.wordsassemblyapi.infrastructure.approval.dto.FindApprovalDto;
import com.wordsassemblyapi.mapper.approval.ApprovalQueryMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApprovalQueryRepository {

  private final ApprovalQueryMapper approvalQueryMapper;

  public ApprovalQueryRepository(
      ApprovalQueryMapper approvalQueryMapper) {
    this.approvalQueryMapper = approvalQueryMapper;
  }

  /**
   * 指定された小説のいいね！情報を全取得.
   * @param novelId 小説ID
   * @return いいね！DTOリスト
   */
  public List<FindApprovalDto> findApprovalsById(Integer novelId) {
    List<FindApprovalData> dataList = approvalQueryMapper.selectApprovalsById(novelId);

    if (CollectionUtils.isEmpty(dataList)) {
      return null;
    }

    List<FindApprovalDto> dtoList = new ArrayList<>();
    for (FindApprovalData data : dataList) {
      dtoList.add(new FindApprovalDto(
          data.getId(), data.getNovelId(), data.getFromAuthorId(), data.getToAuthorId(),
          data.getCreatedAt(), data.getUpdatedAt(), data.getDeletedAt()));
    }

    return dtoList;
  }
}
