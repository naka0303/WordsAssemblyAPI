package com.wordsassemblyapi.mapper.novel;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import com.wordsassemblyapi.infrastructure.novel.dto.UpdateNovelDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NovelCommandMapper {
  int insertNovel(
      @Param("dto") RegisterNovelDto dto);

  int deleteNovelById(
      @Param("novelId") Integer novelId);

  int updateNovelById(
      @Param("novelId") Integer novelId,
      @Param("dto") UpdateNovelDto dto);
}
