package com.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PMemberVO {

	private int id;
	
	private String name;
	
	private String password;
	
	private Date regdate;

	private String email;
	
}
