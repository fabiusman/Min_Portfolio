package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.dao.PPostDAO;
import com.board.vo.PPostVO;
import com.board.vo.util.Criteria;
import com.board.vo.util.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PPostServcie {

	private final PPostDAO dao;
	
	//crud
	public void write(PPostVO vo) throws Exception {
		//조회수 설정(조립)
		vo.setHits(0);
		
		dao.insert(vo);
	}
	
	public PPostVO detail(int id) throws Exception {
		dao.hitsUpdate(id);
		
		return dao.read(id);
	}
	
	//관리자용
	public List<PPostVO> list() throws Exception {
		return dao.list();
	}
	
	//update, delete에선 id 활용?
	public void update(PPostVO vo) throws Exception {
		dao.update(vo);
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	//페이징 + 검색
	public List<PPostVO> listPaging(Criteria cri) throws Exception  {
		return dao.listPaging(cri);
	}
	
	public List<PPostVO> listSearch(SearchCriteria scri) throws Exception  {
		return dao.listSearch(scri);
	}
	
	public int totalRow() throws Exception  {
		return dao.totalRow();
	}
	
}
