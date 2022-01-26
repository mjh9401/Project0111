package com.mjh.exam.Test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjh.exam.Test1.Service.ArticleServcie;

@Controller
public class ArticleController {
	@Autowired
	private ArticleServcie articleService;
	
	@RequestMapping("article/list")
	public String showList() {
		
		return "usr/article/list";
	}
	
	@RequestMapping("article/write")
	public String showWrite() {
		return "usr/article/write";
	}
}
