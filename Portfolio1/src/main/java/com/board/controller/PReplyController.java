package com.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.service.PReplyServcie;
import com.board.vo.PReplyVO;
import com.board.vo.util.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PReplyController {

	private static final Logger log = LoggerFactory.getLogger(PReplyController.class);
	
	private final PReplyServcie service;

	
	@RequestMapping("/preply/write.do")
	public String write(PReplyVO vo, int post_id, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("reply.write.do");
		
		service.write(vo, post_id);
		
		rttr.addAttribute("id", post_id);
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/detail.do";
		
	}
	
	@RequestMapping("/preply/update")
	public String updateForm(int id, int post_id, Model model, SearchCriteria scri) throws Exception {
		log.info("reply.updateForm");
		
		PReplyVO reply = service.detail(id);
		
		model.addAttribute("post_id", post_id);
		model.addAttribute("scri", scri);
		model.addAttribute("preply", reply);
		
		return "preply/update";
		
	}
	
	@RequestMapping("/preply/update.do")
	public String update(PReplyVO vo, int post_id, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("reply.update.do");
		
		service.update(vo);
		
		rttr.addAttribute("id", post_id);
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/detail.do";
		
	}
	
	@RequestMapping("/preply/delete")
	public String deleteForm(int id, int post_id, Model model, SearchCriteria scri) throws Exception {
		log.info("reply.deleteForm");
		
		PReplyVO reply = service.detail(id);
		
		model.addAttribute("post_id", post_id);
		model.addAttribute("scri", scri);
		model.addAttribute("preply", reply);
		
		return "preply/delete";
		
	}
	
	@RequestMapping("/preply/delete.do")
	public String delete(int id, int post_id, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("reply.delete.do");
		
		service.delete(id);
		
		rttr.addAttribute("id", post_id);
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("amount", scri.getAmount());
		rttr.addAttribute("keyword", scri.getKeyword());
		rttr.addAttribute("searchType", scri.getSearchType());
		
		return "redirect:/ppost/detail.do";
		
	}
	
}
