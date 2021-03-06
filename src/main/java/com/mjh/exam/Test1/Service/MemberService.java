package com.mjh.exam.Test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mjh.exam.Test1.Dao.MemberDao;
import com.mjh.exam.Test1.Dto.Member;
import com.mjh.exam.Test1.Ut.Ut;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private UserMailService UserMailService;
	@Value("${custom.siteMainUri}")
	private String siteMainUri;
    @Value("${custom.siteName}")
    private String siteName;

	public int dojoin(String loginId, String loginPw,String name, String nickName,
			String cellphoneNo, String email) {
		Member oldMember = getMemberbyId(loginId);
		
		if(oldMember != null) {
			return -1;
		}
		
		oldMember = getMemberbyNameAndEmail(name,email);
		
		if(oldMember != null) {
			return -2;
		}
		
		memberDao.doJoin(loginId,loginPw,name,nickName,cellphoneNo,email);
		
		return memberDao.getLastInsertId();
	}

	private Member getMemberbyNameAndEmail(String name, String email) {
		
		return memberDao.getMemberbyNameAndEmail(name,email);
	}

	private Member getMemberbyId(String loginId) {
		
		return memberDao.getMemberbyId(loginId);
	}

	public Member getMemberByLoginId(String loginId) {

		return memberDao.getMemberByLoginId(loginId);
	}
	
	public Member getMemberByLoginedId(int loginedMemberId) {

		return memberDao.getMemberByLoginedId(loginedMemberId);
	}

	public Member findMember(String name, String email) {
		
		return memberDao.findMembmer(name,email);
	}

	public Member findMemberPw(String loginId, String email) {
		
		return memberDao.findMemberPw(loginId,email);
	}

	public void findMemberforDrop(String loginId, String password) {

		memberDao.findMemberforDrop(loginId,password);
	}

	public void doMemberModify(int id,String password, String cellphoneNo, String email) {
		memberDao.doMemberModify(id,password,cellphoneNo,email);
	}

	public Member findMemberByLoginId(String loginId) {

		return memberDao.findMemberByLoginId(loginId);
	}

	public String notifyTempLoginPwByEmail(Member member) {
		String title = "[" + siteName + "] ?????? ???????????? ??????";
        String tempPassword = Ut.getTempPassword(6);
        String body = "<h1>?????? ???????????? : " + tempPassword + "</h1>";
        body += "<a href=\"" + siteMainUri + "member/login\" target=\"_blank\">????????? ????????????</a>";

        String Result = UserMailService.send(member.getEmail(), title, body);

        if (Result.contains("??????")) {
            return "?????? ????????? ??????????????????.";
        }

        setTempPassword(member, tempPassword);

        return "????????? ?????????????????? ?????? ??????????????? ?????????????????????.";

	}

	private void setTempPassword(Member member, String tempPassword) {
		memberDao.remodify(member.getId(),Ut.sha256(tempPassword), null, null, null, null);
	}





}
