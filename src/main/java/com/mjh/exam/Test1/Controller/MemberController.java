package com.mjh.exam.Test1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("member/login")
	public String ShowLogin() {
		return "usr/member/login";
	}
	
	@RequestMapping("member/join")
	public String ShowJoin() {
		return "usr/member/join";
	}
	
}
