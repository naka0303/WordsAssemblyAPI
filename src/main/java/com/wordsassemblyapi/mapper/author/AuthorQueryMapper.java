package com.wordsassemblyapi.mapper.author;

import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorData;
import com.wordsassemblyapi.infrastructure.author.dto.FindAuthorDto;
import com.wordsassemblyapi.infrastructure.author.dto.RegisterAuthorDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorQueryMapper {

  FindAuthorData selectAuthorByEmail(
      @Param("email") String email);
}
