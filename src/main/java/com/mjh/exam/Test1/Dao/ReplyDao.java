package com.mjh.exam.Test1.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.Test1.Dto.Reply;

@Mapper
public interface ReplyDao {

	void doWrite(@Param("articleId") int articleId,@Param("memberId") int memberId, @Param("body") String body);

	List<Reply> SearchRepliesByArticleId(@Param("id") int id);

	void doDelete(@Param("replyId") int replyId);

}
