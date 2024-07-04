package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.vo.PPostVO;
import com.board.vo.util.Criteria;
import com.board.vo.util.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PPostDAO {

	private final SqlSession sql;
	private String mapper = "com.board.mapper.pPostMapper";
	
	//crud
	public void insert(PPostVO vo) throws Exception {
		sql.insert(mapper + ".insert", vo);
	}
	
	public PPostVO read(int id) throws Exception {
		return sql.selectOne(mapper + ".read", id);
	}
	
	//list 기능은 또 쓸 지도 모르니 남겨둔다.
	public List<PPostVO> list() throws Exception {
		return sql.selectList(mapper + ".list");
	}
	
	public void update(PPostVO vo) throws Exception {
//		System.out.println(vo.getPassword());
		
		sql.update(mapper + ".update", vo);
	}
	
	public void delete(int id) throws Exception {
		sql.delete(mapper + ".delete", id);
	}
	
	//추가
	//1. 조회수
	public void hitsUpdate(int id) throws Exception {
		PPostVO post = this.read(id);
		
		int hits = post.getHits();
		post.setHits(++hits);
		
		sql.update(mapper + ".hitsUpdate", post);
	}
	
	//2. 페이징 + 검색
	public List<PPostVO> listPaging(Criteria cri) throws Exception  {
		return sql.selectList(mapper + ".listPaging", cri);
	}
	
	public List<PPostVO> listSearch(SearchCriteria scri) throws Exception  {
		return sql.selectList(mapper + ".listSearch", scri);
	}
	
	//3. 게시글 총 개수
	public int totalRow() throws Exception  {
		return sql.selectOne(mapper + ".totalRow");
	}
}
