package com.mjh.exam.Test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.Test1.Dto.Member;
import com.mjh.exam.Test1.Dto.Rq;
import com.mjh.exam.Test1.Service.MemberService;
import com.mjh.exam.Test1.Ut.Ut;


@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private Rq rq;
		
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
		
		loginPw = Ut.sha256(loginPw);
		
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
	
	@RequestMapping("member/findId")
	public String showFindId() {
		
		return "usr/member/finedId";
	}
	
	@RequestMapping("member/doFindId")
	@ResponseBody
	public String doFindId(String name, String email) {
		
		if(Ut.empty(name)) {
			return Ut.jsHistoryBack("이름을 입력해주세요");
		}
		
		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일을 입력해주세요");
		}
		
		Member oldmember= memberService.findMember(name,email);
		
		if(oldmember == null) {
			return Ut.jsHistoryBack("해당 회원 존재하지 않습니다.");
		}
		
		return Ut.jsReplace(Ut.f("%s님의 아이디는 %s입니다.",oldmember.getName(),oldmember.getLoginId()),"../member/login");
	}
	
	@RequestMapping("member/findPw")
	public String showFindPw() {
		
		return "usr/member/finedPw";
	}
	
	@RequestMapping("member/dofidnPw")
	@ResponseBody
	public String doFindPw(String loginId, String email) {
		
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요");
		}
		
		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일을 입력해주세요");
		}
		
		Member oldMember= memberService.findMemberPw(loginId,email);
		
		if(oldMember == null) {
			return Ut.jsHistoryBack("해당 회원은 존재하지 않습니다.");
		}
		
		if(oldMember.getLoginId().equals(loginId) == false) {
			return Ut.jsHistoryBack("해당 회원은 존재하지 않습니다.");
		}
		
		memberService.notifyTempLoginPwByEmail(oldMember);
		
		return Ut.jsReplace(Ut.f("%s님 해당 이메일로 임시 비밀번호 발송됐습니다.",oldMember.getName()),"../member/login");
	}
	
	@RequestMapping("member/memberDrop")
	public String showMemberDrop() {
		
		return "usr/member/memberDrop";
	}
	
	@RequestMapping("member/doMemberDrop")
	@ResponseBody
	public String doFindPw(String loginId, String password, String passwordConfirm) {
		
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요");
		}
		
		// 현재 로그인 아이디와 입력한 아이디가 일치하는 확인 로직
		
		if(!password.equals(passwordConfirm)) {
			return Ut.jsHistoryBack("비번이 일치하지 않습니다.");
		}
		
		memberService.findMemberforDrop(loginId,password);
		
		return Ut.jsReplace("회원탈퇴 완료됐습니다.","../member/login");
	}
	
	@RequestMapping("member/memberModify")
	public String showmemberModify() {
		
		return "usr/member/memberModify";
	}
	
	@RequestMapping("member/doMemberModify")
	@ResponseBody
	public String doMemberModify(int id,String password, String passwordConfirm, String cellphoneNo, String email) {
		
		if(Ut.empty(password)) {
			return Ut.jsHistoryBack("비밀번호를 입력해주세요");
		}
		
		if(Ut.empty(passwordConfirm)) {
			return Ut.jsHistoryBack("비밀번호 확인을 입력해주세요");
		}
		
		if(!password.equals(passwordConfirm)) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}
		
		if(Ut.empty(cellphoneNo)) {
			return Ut.jsHistoryBack("휴대전화번호을 입력해주세요");
		}
		
		if(Ut.empty(email)) {
			return Ut.jsHistoryBack("이메일을 입력해주세요");
		}
		
		
		memberService.doMemberModify(id,password,cellphoneNo,email);
		
		return Ut.jsReplace("회원정보 수정이 완료됐습니다..","../member/login");
	}
	
	@RequestMapping("member/login")
	public String ShowLogin() {
		return "usr/member/login";
	}
	
	@RequestMapping("member/doLogin")
	@ResponseBody
	public String dologin(String loginId,String loginPw) {
		
		if(Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요");
		}
		
		if(Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력해주세요");
		}
		
		Member member = memberService.findMemberByLoginId(loginId);
		
		if(member == null) {
			return Ut.jsHistoryBack("존재하지 않는 회원입니다.");
		}
		
		if(!member.getLoginPw().equals(Ut.sha256(loginPw))) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}
				
		rq.login(member);
				
		return Ut.jsReplace(Ut.f("%s님 환영합니다.", member.getNickName()),"/main");
	}
	
	@RequestMapping("member/logout")
	@ResponseBody
	public String doLogout() {
		
		rq.logout();

		return Ut.jsReplace("로그아웃 됐습니다.", "/main");
	}
	
}
