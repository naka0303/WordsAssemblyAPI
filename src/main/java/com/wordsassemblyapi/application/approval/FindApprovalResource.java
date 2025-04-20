package com.wordsassemblyapi.application.approval;

import com.wordsassemblyapi.domain.approvals.entity.Approval;
import com.wordsassemblyapi.infrastructure.approval.dto.FindApprovalDto;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class FindApprovalResource {

  /**
   * DTOList -> EntityList変換.
   * @param dtoList いいね！DTOリスト
   * @return いいね！エンティティリスト
   */
  public List<Approval> toEntityList(List<FindApprovalDto> dtoList) {
    if (CollectionUtils.isEmpty(dtoList)) {
      return null;
    }

    List<Approval> approvals = new ArrayList<>();
    for (FindApprovalDto dto : dtoList) {
      approvals.add(new Approval(
          dto.getId(),
          dto.getNovelId(),
          dto.getFromAuthorId(),
          dto.getToAuthorId(),
          dto.getCreatedAt(),
          dto.getUpdatedAt(),
          dto.getDeletedAt()
      ));
    }

    return approvals;
  }

  /**
   * DTO -> Entity変換.
   * @param dto 著者DTO
   * @return 著者エンティティ
   */
  public Approval toEntity(FindApprovalDto dto) {
    if (dto == null) {
      return null;
    }

    return new Approval(
        dto.getId(),
        dto.getNovelId(),
        dto.getFromAuthorId(),
        dto.getToAuthorId(),
        dto.getCreatedAt(),
        dto.getUpdatedAt(),
        dto.getDeletedAt()
    );
  }

}
