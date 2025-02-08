package com.wordsassemblyapi.mapper.author;

import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorCommandMapper {
  int insertAuthor(
      @Param("dto") RegisterAuthorDto dto);
}
