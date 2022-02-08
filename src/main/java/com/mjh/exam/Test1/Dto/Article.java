package com.mjh.exam.Test1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	int id;
	String regDate;
	String updateDate;
	int boardId;
	String title;
	String body;
}
