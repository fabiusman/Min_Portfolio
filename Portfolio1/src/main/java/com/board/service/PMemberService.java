package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.dao.PMemberDAO;
import com.board.vo.PMemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PMemberService {

	private final PMemberDAO dao;
	
	public void register(PMemberVO vo) throws Exception {
		
		//중복 검증
		String email = vo.getEmail();
		
		PMemberVO member = dao.readByEmail(email);
		
		if(member == null) {
			dao.insert(vo);
		} //else로 에러처리 필요
	}
	
	public PMemberVO login(PMemberVO vo) throws Exception {
		
		PMemberVO member = dao.read(vo);
		
		if(member != null) {
			return member;
		} //else 에러처리 필요
		
		return null;
	}
	
	//관리자용
	public List<PMemberVO> listPMembers() throws Exception {
		return dao.list();
	}
	
	//update, delete에선 id 활용?
	public void update(PMemberVO vo) throws Exception {
		dao.update(vo);
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
}
