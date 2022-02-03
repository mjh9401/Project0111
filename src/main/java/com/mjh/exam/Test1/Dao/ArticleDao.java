package com.mjh.exam.Test1.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.Test1.Dto.Article;

@Mapper
public interface ArticleDao {
	void doWrite(@Param("title") String title,@Param("body") String body);

	Article checkArticle(@Param("title") String title,@Param("body") String body);

	ArrayList<Article> list();

	Article searchArticleByid(@Param("id") int id);

	void doDelete(@Param("id") int id);

	void doModify(@Param("id") int id, @Param("body") String body);

}
