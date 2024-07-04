package com.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PImageVO {

	private int id;
	
	private String original_name;
	
	private String new_name;
	
	private String file_path;
	
	private String entension;
	
	private Date regdate;
	
	private int post_id;
	
}
