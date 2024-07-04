package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.vo.PMemberVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PMemberDAO {

	private final SqlSession sql;
	private String mapper = "com.board.mapper.pMemberMapper";
	
	//crud
	public void insert(PMemberVO vo) throws Exception {
		sql.insert(mapper + ".insert", vo);
	}
	
	public PMemberVO read(PMemberVO vo) throws Exception {
		return sql.selectOne(mapper + ".read", vo);
	}
	
	public List<PMemberVO> list() throws Exception {
		return sql.selectList(mapper + ".list");
	}
	
	public void update(PMemberVO vo) throws Exception {
//		System.out.println(vo.getPassword());
		
		sql.update(mapper + ".update", vo);
	}
	
	public void delete(int id) throws Exception {
		sql.delete(mapper + ".delete", id);
	}
	
	//추가
	public PMemberVO readByEmail(String email) throws Exception {
		return sql.selectOne(mapper + ".read", email);
	}
	
}
