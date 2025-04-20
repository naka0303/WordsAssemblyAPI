package com.wordsassemblyapi.mapper.approval;

import com.wordsassemblyapi.infrastructure.approval.dto.FindApprovalData;
import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApprovalQueryMapper {

  List<FindApprovalData> selectApprovalsById(
      @Param("novelId") Integer novelId);
}
