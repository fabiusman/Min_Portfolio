package com.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.dao.PMemberDAO;
import com.board.service.PMemberService;
import com.board.vo.PMemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PMemberController {

	private static final Logger log = LoggerFactory.getLogger(PMemberController.class);
	
	private final PMemberService service;
	
	//기본
	@RequestMapping("/")
	public String index() throws Exception {
		log.info("index");
		
		return "index";
	}
	
	@RequestMapping("/pmember/login.do")
	public String login(PMemberVO vo, HttpSession session) throws Exception {
		log.info("login.do");
		//return null인경우 있으니
		PMemberVO login = service.login(vo);
		
		if(login==null){
			log.info("loginError");
			return "pmember/error/loginError";
		}
		
		session.setAttribute("login", login);
		
		return "redirect:/";
	}
	
	@RequestMapping("/pmember/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("/pmember/register")
	public String registerForm() throws Exception {
		log.info("regsiterForm");
		
		return "pmember/register";
	}
	
	@RequestMapping("/pmember/register.do")
	public String register(PMemberVO vo) throws Exception {
		log.info("register.do");
		
//		try {
			service.register(vo);
//		}catch(Exception e) {
//			log.info("registerError");
//			return "error/registerError";
//		}
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/pmember/update")
	public String updateForm(Model model, HttpSession session) throws Exception {
		log.info("update");
		
		//세션에서 끄내올 댼 cast!!
		PMemberVO pmember = (PMemberVO) session.getAttribute("login");
		
		model.addAttribute("pmember", pmember);
		
		return "pmember/update";
	}
	
	@RequestMapping("/pmember/update.do")
	public String update(PMemberVO vo) throws Exception {
		log.info("update.do");
//		System.out.println(vo.getPassword());
		
		service.update(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/pmember/delete")
	public String deleteForm() throws Exception {
		log.info("delete");
		
		return "pmember/delete";
	}
	
	@RequestMapping("/pmemeber/delete.do")
	public String delete(int id, HttpSession session) throws Exception {
		log.info("delete.do");
		
		service.delete(id);
		session.invalidate();
		
		return "redirect:/";
	}
	
	//에러
	@RequestMapping("/pmember/loginError")
	public String loginError() throws Exception {
		return "pmember/error/loginError";
	}

	@RequestMapping("/pmember/registerError")
	public String registerError() throws Exception {
		return "pmember/error/registerError";
	}

	@RequestMapping("/pmember/upDelError")
	public String upDelError() throws Exception {
		return "pmember/error/upDelError";
	}
	
}
