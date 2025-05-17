package com.wordsassemblyapi.mapper.approval;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterApprovalDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApprovalCommandMapper {

  int insertApproval(
      @Param("novelId") Integer novelId,
      @Param("dto") RegisterApprovalDto dto);

  int deleteApprovalByAuthor(
      @Param("novelId") Integer novelId,
      @Param("authorId") Integer authorId);
}
