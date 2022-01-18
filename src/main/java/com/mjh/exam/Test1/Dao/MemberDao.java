package com.mjh.exam.Test1.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.Test1.Dto.Member;

@Mapper
public interface MemberDao {
	
	Member getMemberbyId(@Param("loginId") String loginId);
	
	Member getMemberbyNameAndEmail(@Param("name") String name,@Param("email") String email);
	
	void doJoin(@Param("loginId") String loginId,@Param("loginPw") String loginPw,@Param("name") String name, 
			@Param("nickName") String nickName,@Param("cellphoneNo") String cellphoneNo,@Param("email") String email);
	
	int getLastInsertId();

	Member getMemberByLoginId(@Param("loginId") String loginId);

}
