package com.mjh.exam.Test1.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.Test1.Dto.Article;

@Mapper
public interface ArticleDao {
	void doWrite(@Param("title") String title,@Param("body") String body,@Param("boardId") int boardId);

	Article checkArticle(@Param("title") String title,@Param("body") String body,@Param("boardId") int boardId);

	ArrayList<Article> list(@Param("boardId") int boardId,@Param("searchKeyword") String searchKeyword);

	Article searchArticleByid(@Param("id") int id);

	void doDelete(@Param("id") int id);

	void doModify(@Param("id") int id, @Param("body") String body);

	int searchBoardIdById(@Param("id") int id);

}
