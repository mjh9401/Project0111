package com.mjh.exam.Test1.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.Test1.Dto.Article;
import com.mjh.exam.Test1.Service.ArticleServcie;
import com.mjh.exam.Test1.Ut.Ut;

@Controller
public class ArticleController {
	@Autowired
	private ArticleServcie articleService;
	
	
	@RequestMapping("article/list")
	public String showList(Model model, int boardId,@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "") String searchKeyword) {
		// 해당 게시글 총 갯수
		int articlesCount = articleService.getArticlesCount(boardId,searchKeyword);
		// 한 페이지에 게시글 갯수
		int itemsCountInAPage = 10;
		// 전체 페이지 수 = (해당 게시글 총 갯수 / 한 페이지에 게시글 갯수)
		int pageCount = (int) Math.ceil((double)articlesCount/itemsCountInAPage);
		
		// 해당 게시글 전체 가져오기
		ArrayList<Article> articles= articleService.list(boardId,searchKeyword,page,itemsCountInAPage);
		
		model.addAttribute("articles", articles);
		model.addAttribute("boardId", boardId);
		model.addAttribute("articlesCount", articlesCount);
		model.addAttribute("itemsCountInAPage", itemsCountInAPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", page);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "usr/article/list";
	}
	
	@RequestMapping("article/write")
	public String showWrite(Model model,int boardId) {
		model.addAttribute("boardId", boardId);
		
		return "usr/article/write";
	}
	
	@RequestMapping("article/doWrite")
	@ResponseBody
	public String doWrite(String title,String body,int boardId) {
		if(Ut.empty(title)) {
			return "제목을 입력해주세요";
		}
		
		if(Ut.empty(body)) {
			return "내용을 입력해주세요";
		}
		
		articleService.doWrtie(title,body,boardId);
		Article article = articleService.checkArticle(title,body,boardId);
		
		if(article == null) {
			return "게시글 작성이 되지 않았습니다.";
		}
			
		return Ut.jsReplace("게시글 작성이 완료됐습니다.", "../article/list?boardId="+boardId);
	}
	
	@RequestMapping("article/detail")
	public String detail(Model model,int id) {

		Article article = articleService.searchArticleByid(id);
		
		if(article == null) {
			return Ut.jsHistoryBack("해당 게시글은 존재하지 않습니다.");
		}
				
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}
	
	@RequestMapping("article/doIncreaseHitCount")
	@ResponseBody
	public int doIncreaseHitCount(int id) {
		articleService.doIncreaseHitCount(id);
		
		int ResultHitCount = articleService.ResultHitCount(id);
		
		return ResultHitCount;
	}
	
	@RequestMapping("article/delete")
	@ResponseBody
	public String doDelete(int id) {
		int boardId = articleService.searchBoardIdById(id);		
		Article article = articleService.doDelete(id);
		
		if(article != null) {
			return Ut.jsHistoryBack("해당 게시글이 삭제되지 않았습니다.");
		}
			
		return Ut.jsReplace("해당 게시글은 삭제 됐습니다.","../article/list?boardId="+boardId);
	}
	
	@RequestMapping("article/modify")
	public String showModify(Model model,int id) {
		int boardId = articleService.searchBoardIdById(id);
		Article article = articleService.searchArticleByid(id);

		if(article == null) {
			return Ut.jsReplace("해당 게시글이 존재하지 않습니다.", "../article/list?boardId="+boardId);
		}
		
		model.addAttribute("article", article);
		
		return "usr/article/modify";
	}
	
	@RequestMapping("article/doModify")
	@ResponseBody
	public String doModify(int id, String body) {
		int boardId = articleService.searchBoardIdById(id);
		
		if(Ut.empty(id)) {
			return Ut.jsReplace("해당게시물은 존재하지 않습니다.", "../article/list?boardId="+boardId);
		}
		if(Ut.empty(body)) {
			return Ut.jsReplace("해당게시물은 존재하지 않습니다.", "../article/list?boardId="+boardId);
		}
		
		articleService.doModify(id,body);
	
		return Ut.jsReplace("게시물 수정 됐습니다.", "../article/list?boardId="+boardId);
	}
}
