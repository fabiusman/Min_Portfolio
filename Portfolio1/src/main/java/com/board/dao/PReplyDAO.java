package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.vo.PReplyVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PReplyDAO {

	private final SqlSession sql;
	private String mapper = "com.board.mapper.pReplyMapper";
	
	//crud
	public void insert(PReplyVO vo) throws Exception {
		sql.insert(mapper + ".insert", vo);
	}
	
	public PReplyVO read(int id) throws Exception {
		return sql.selectOne(mapper + ".read", id);
	}
	
	public List<PReplyVO> list(int post_id) throws Exception {
		return sql.selectList(mapper + ".list", post_id);
	}
	
	public void update(PReplyVO vo) throws Exception {		
		sql.update(mapper + ".update", vo);
	}
	
	public void delete(int id) throws Exception {
		sql.delete(mapper + ".delete", id);
	}
	
}