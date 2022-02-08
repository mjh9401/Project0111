package com.mjh.exam.Test1.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.Test1.Dao.ArticleDao;
import com.mjh.exam.Test1.Dto.Article;

@Service
public class ArticleServcie {
	@Autowired
	private ArticleDao articleDao;

	public void doWrtie(String title, String body, int boardId) {
		articleDao.doWrite(title,body,boardId);
	}

	public Article checkArticle(String title, String body, int boardId) {
		return articleDao.checkArticle(title,body,boardId);
	}

	public ArrayList<Article> list(int boardId) {
		
		return articleDao.list(boardId);
	}

	public Article searchArticleByid(int id) {
		
		return articleDao.searchArticleByid(id);
	}

	public Article doDelete(int id) {
		articleDao.doDelete(id);
		Article article = articleDao.searchArticleByid(id);
		
		return article;
	}

	public void doModify(int id, String body) {
		articleDao.doModify(id,body);
	}

	public int searchBoardIdById(int id) {
		return articleDao.searchBoardIdById(id);
	}
}
