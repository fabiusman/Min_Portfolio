package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.dao.PReplyDAO;
import com.board.vo.PReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PReplyServcie {

	private final PReplyDAO dao;
	
	//crud
	public void write(PReplyVO vo, int post_id) throws Exception {
		vo.setPost_id(post_id);
		
		dao.insert(vo);
	}
	
	public PReplyVO detail(int id) throws Exception {		
		return dao.read(id);
	}
	
	//관리자용
	public List<PReplyVO> list(int post_id) throws Exception {
		return dao.list(post_id);
	}
	
	//update, delete에선 id 활용?
	public void update(PReplyVO vo) throws Exception {
		dao.update(vo);
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}

}
