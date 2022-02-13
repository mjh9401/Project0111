package com.mjh.exam.Test1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	int id;
	String regDate;
	String updateDate;
	int articleId;
	int memberId;
	String body;
}
