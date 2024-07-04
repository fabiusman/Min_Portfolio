package com.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PReplyVO {

	private int id;
	
	private String writer;
	
	private String content;
	
	private Date  regdate;
	
	private int post_id;
	
}
