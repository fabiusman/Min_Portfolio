package com.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PPostVO {

	private int id;
	
	private String title;
	
	private String writer;
	
	private String content;
	
	private Date regdate;
	
	private int hits;
	
}
