package com.mjh.exam.Test1.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.Test1.Dto.Rq;
import com.mjh.exam.Test1.Service.ReplyService;
import com.mjh.exam.Test1.Ut.Ut;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	
	@RequestMapping("reply/doWrite")
	@ResponseBody
	public String doWrite(int articleId,int memberId,String body) {
		replyService.doWrite(articleId,memberId,body);
		
		return Ut.jsReplace("댓글작성이 완료됐습니다.","../main");
	}
	
	@RequestMapping("reply/doDelete")
	@ResponseBody
	public String doDelete(int replyId) {
		replyService.doDelete(replyId);
		
		return Ut.jsReplace("댓글삭제가 완료됐습니다.","../main");
	}
	
	@RequestMapping("reply/modifySignal")
	public String modifySignal(HttpServletRequest req,int articleId) {
		String modifySignal = "yes";
		
		req.setAttribute("modifySignal", modifySignal);
		
		return "redirect:/article/detail?id="+articleId;
	}
}
