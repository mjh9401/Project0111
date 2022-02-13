package com.mjh.exam.Test1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.Test1.Dao.ReplyDao;
import com.mjh.exam.Test1.Dto.Reply;


@Service
public class ReplyService {
	@Autowired
	ReplyDao replyDao;
	
	public void doWrite(int articleId, int memberId, String body) {
		replyDao.doWrite(articleId,memberId,body);
	}

	public List<Reply> SearchRepliesByArticleId(int id) {
		return replyDao.SearchRepliesByArticleId(id);
	}

	public void doDelete(int replyId) {
		replyDao.doDelete(replyId);
	}
}	
