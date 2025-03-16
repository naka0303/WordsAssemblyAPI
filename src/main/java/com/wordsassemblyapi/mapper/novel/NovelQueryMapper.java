package com.wordsassemblyapi.mapper.novel;

import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NovelQueryMapper {

  List<FindNovelData> selectNovelsByAuthor(
      @Param("authorId") Integer authorId,
      @Param("isPublish") Boolean isPublish);
}
