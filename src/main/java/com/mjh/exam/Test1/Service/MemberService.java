package com.mjh.exam.Test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.Test1.Dao.MemberDao;
import com.mjh.exam.Test1.Dto.Member;
import com.mjh.exam.Test1.Dto.Rq;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

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

	public Member getMemberByLoginId(int loginMemberId) {
		
		return memberDao.getMemberByLoginId(loginMemberId);
	}

	


}
