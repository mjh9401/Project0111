package com.mjh.exam.Test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.Test1.Dto.Member;
import com.mjh.exam.Test1.Service.MemberServie;
import com.mjh.exam.Test1.Ut.Ut;


@Controller
public class MemberController {
	@Autowired
	private MemberServie memberService;
	
	@RequestMapping("member/login")
	public String ShowLogin() {
		return "usr/member/login";
	}
	
	@RequestMapping("member/join")
	public String ShowJoin() {
		return "usr/member/join";
	}
	
	@RequestMapping("member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw,String loginPwConfirm,String name,String nickName,String cellphoneNo,String email) {
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요");
		}
		if(Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력해주세요");
		}
		if(Ut.empty(loginPwConfirm)) {
			return Ut.jsHistoryBack("비밀번호 확인을 입력해주세요");
		}
				
		if(!loginPw.equals(loginPwConfirm)) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}
		
		if(Ut.empty(nickName)) {
			return Ut.jsHistoryBack("닉네임을 입력해주세요");
		}
		if(Ut.empty(cellphoneNo)) {
			return Ut.jsHistoryBack("휴대전화번호를 입력해주세요");
		}
		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일을 입력해주세요");
		}
		
		int id = memberService.dojoin(loginId,loginPw,name,nickName,cellphoneNo,email);
		
		if(id == -1) {
			return Ut.jsHistoryBack("해당 아이디는 사용 중입니다.");
		}
		
		if(id == -2) {
			return Ut.jsHistoryBack("해당 이름과 이메일을 사용중입니다.");
		}
		
		return Ut.jsReplace("회원가입이 완료됐습니다.", "/main");
	}
	
	@RequestMapping("member/getLoginIdDup")
	@ResponseBody
	public String getLoginIdDup(String loginId) {
		if(Ut.empty(loginId)) {
			return "아이디를 입력해주세요";
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member != null) {
			return "해당 아이디는 사용중입니다.";
		}
		
		return "사용가능한 아이디입니다.";
	}
	
	@RequestMapping("member/EmptyCheckLoginPw")
	@ResponseBody
	public String EmptyCheckLoginPw(String loginPw) {
		if(Ut.empty(loginPw)) {
			return "비밀번호를 입력해주세요";
		}
		
		return "";
	}
	
	@RequestMapping("member/EmptyCheckLoginPwConfirm")
	@ResponseBody
	public String EmptyCheckLoginPwConfirm(String loginPwConfirm) {
		if(Ut.empty(loginPwConfirm)) {
			return "비밀번호 재확인을 입력해주세요";
		}
		
		return "";
	}
	
	@RequestMapping("member/EmptyCheckName")
	@ResponseBody
	public String EmptyCheckName(String name) {
		if(Ut.empty(name)) {
			return "이름을 입력해주세요";
		}
		
		return "";
	}
	
	@RequestMapping("member/EmptyCheckNickname")
	@ResponseBody
	public String EmptyCheckNickname(String nickName) {
		if(Ut.empty(nickName)) {
			return "닉네임을 입력해주세요";
		}
		
		return "";
	}
	
	
	@RequestMapping("member/EmptyChecktel")
	@ResponseBody
	public String EmptyChecktel(String cellphoneNo) {
		if(Ut.empty(cellphoneNo)) {
			return "전화번호을 입력해주세요";
		}
		
		return "";
	}
	
	@RequestMapping("member/EmptyCheckEmail")
	@ResponseBody
	public String EmptyCheckEmail(String email) {
		if(Ut.empty(email)) {
			return "이메일를 입력해주세요";
		}
		
		return "";
	}
}
