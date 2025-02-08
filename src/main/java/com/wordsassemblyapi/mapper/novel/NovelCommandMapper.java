package com.wordsassemblyapi.mapper.novel;

import com.wordsassemblyapi.infrastructure.novel.dto.RegisterNovelDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NovelCommandMapper {
  int insertNovel(
      @Param("dto") RegisterNovelDto dto);
}
