package com.mjh.exam.Test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.Test1.Dao.ArticleDao;

@Service
public class ArticleServcie {
	@Autowired
	private ArticleDao articleDao;
}
