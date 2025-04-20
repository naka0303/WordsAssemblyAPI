package com.wordsassemblyapi.mapper.approval;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterApprovalDto;
import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.infrastructure.novel.dto.UpdateNovelDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApprovalCommandMapper {

  int insertApproval(
      @Param("novelId") Integer novelId,
      @Param("dto") RegisterApprovalDto dto);
}
