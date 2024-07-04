package com.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.service.PPostServcie;
import com.board.service.PReplyServcie;
import com.board.vo.PMemberVO;
import com.board.vo.PPostVO;
import com.board.vo.PReplyVO;
import com.board.vo.util.Criteria;
import com.board.vo.util.PageMaker;
import com.board.vo.util.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PPostController {

	private static final Logger log = LoggerFactory.getLogger(PPostController.class);
	
	private final PPostServcie service;
	private final PReplyServcie rservice;
	
	@RequestMapping("/ppost/write")
	public String writeForm(PPostVO vo, HttpSession session, Model model, SearchCriteria scri) throws Exception {
		log.info("post.writeForm");
		
		PMemberVO member = (PMemberVO)session.getAttribute("login");
		
		//페이지 유지시 rttr처리
		if(member==null) {
			model.addAttribute("scri", scri);
			
			return "ppost/error/writerError";
		}
		
		model.addAttribute("scri", scri);
		model.addAttribute("writer", member);
		
		return "ppost/write";
		
	}
	
	@RequestMapping("/ppost/write.do")
	public String write(PPostVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("post.write.do");
		
		service.write(vo);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/list.do";
		
	}
	
	@RequestMapping("/ppost/detail.do")
	public String detail(int id, Model model, SearchCriteria scri, HttpSession session) throws Exception {
		log.info("post.detail.do");
		
		PPostVO post = service.detail(id);
		List<PReplyVO> replies = rservice.list(id);
		
		model.addAttribute("scri", scri);
		model.addAttribute("ppost", post);
		model.addAttribute("replies", replies);
		model.addAttribute("rwriter", session.getAttribute("login"));
		
		return "ppost/detail";
		
	}
	
	//list
	@RequestMapping("/ppost/list.do")
	public String listPaging(SearchCriteria scri, Model model) throws Exception {
		log.info("post.list.do");
		
		List<PPostVO> posts = service.listSearch(scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalRow(service.totalRow());
		
		model.addAttribute("scri", scri);
		model.addAttribute("pposts", posts);
		model.addAttribute("pageMaker", pageMaker);
		
		return "ppost/post";
		
	}
	
	//list검색
//	@RequestMapping("/ppost/listSearch.do")
//	public String listSearch(SearchCriteria scri, Model model) throws Exception {
//		log.info("post.listSearch.do");
//		
//		List<PPostVO> posts = service.list();
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(scri);
//		pageMaker.setTotalRow(service.totalRow());
//		
//		model.addAttribute("pposts", posts);
//		model.addAttribute("pageMaker", pageMaker);
//		
//		return "ppost/post";
//		
//	}
	
	@RequestMapping("/ppost/update")
	public String updateForm(int id, Model model, SearchCriteria scri) throws Exception {
		log.info("post.updateForm");
		
		PPostVO post = service.detail(id);
		
		model.addAttribute("scri", scri);
		model.addAttribute("ppost", post);
		
		return "ppost/update";
		
	}
	
	@RequestMapping("/ppost/update.do")
	public String update(PPostVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("post.update.do");
		
		service.update(vo);
		
		rttr.addAttribute("id", vo.getId());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/detail.do";
		
	}
	
	@RequestMapping("/ppost/delete")
	public String deleteForm(int id, Model model, SearchCriteria scri) throws Exception {
		log.info("post.deleteForm");
		
		PPostVO post = service.detail(id);
		
		model.addAttribute("scri", scri);
		model.addAttribute("ppost", post);
		
		return "ppost/delete";
		
	}
	
	@RequestMapping("/ppost/delete.do")
	public String delete(int id, SearchCriteria scri,  RedirectAttributes rttr) throws Exception {
		log.info("post.delete.do");
		
		service.delete(id);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/list.do";
		
	}
	
}
