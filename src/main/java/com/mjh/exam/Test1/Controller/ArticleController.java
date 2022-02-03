package com.mjh.exam.Test1.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.Test1.Dto.Article;
import com.mjh.exam.Test1.Service.ArticleServcie;
import com.mjh.exam.Test1.Ut.Ut;

@Controller
public class ArticleController {
	@Autowired
	private ArticleServcie articleService;
	
	@RequestMapping("article/list")
	public String showList(Model model) {
		ArrayList<Article> articles= articleService.list();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@RequestMapping("article/write")
	public String showWrite() {
		return "usr/article/write";
	}
	
	@RequestMapping("article/doWrite")
	@ResponseBody
	public String doWrite(String title,String body) {
		if(Ut.empty(title)) {
			return "제목을 입력해주세요";
		}
		
		if(Ut.empty(body)) {
			return "내용을 입력해주세요";
		}
		
		articleService.doWrtie(title,body);
		Article article = articleService.checkArticle(title,body);
		
		if(article == null) {
			return "게시글 작성이 되지 않았습니다.";
		}
			
		return Ut.jsReplace("게시글 작성이 완료됐습니다.", "../article/list");
	}
}
