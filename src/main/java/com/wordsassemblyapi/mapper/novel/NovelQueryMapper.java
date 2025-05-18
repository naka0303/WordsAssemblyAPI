package com.wordsassemblyapi.mapper.novel;

import com.wordsassemblyapi.infrastructure.novel.dto.FindNovelData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface NovelQueryMapper {

  List<FindNovelData> selectNovels(
      @Param("isPublish") String isPublish,
      @Param("title") String title,
      @Param("category") String category);

  List<FindNovelData> selectNovelsByAuthor(
      @Param("authorId") Integer authorId);

  FindNovelData selectNovelById(
      @Param("novelId") Integer novelId);
}
