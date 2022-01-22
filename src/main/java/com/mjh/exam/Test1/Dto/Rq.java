package com.mjh.exam.Test1.Dto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mjh.exam.Test1.Service.MemberService;

import lombok.Getter;

@Component
@Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Rq {
	@Getter
	private boolean islogined;
	@Getter
	private int loginMemberId;
	@Getter
	private Member loginedMember;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	public Rq(HttpServletRequest req,HttpServletResponse resp, MemberService memberService) {
		this.req = req;
		this.resp = resp;
		this.session = req.getSession();
		
		if(session.getAttribute("loginIdMember") != null) {
			islogined = true;
			loginMemberId = (int) session.getAttribute("loginMemberId");
			loginedMember = memberService.getMemberByLoginId(loginMemberId);
		}
		
		this.req.setAttribute("rq", this);
	}

	public void login(Member member) {
		session.setAttribute("loginedMember", member);
	}
}
