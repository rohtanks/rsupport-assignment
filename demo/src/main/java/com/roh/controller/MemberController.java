package com.roh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roh.domain.MemberVo;
import com.roh.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	MemberService service;
	
	@GetMapping("login")
	public void login(@RequestParam(value = "error", required = false) String error,
			Model model) {
		logger.info("called login()..");
		if (error != null) {
			logger.info("로그인 에러");
		}
		
	}
	
	@GetMapping("regist")
	public String registGet(MemberVo vo) throws Exception {
		logger.info("called registGet()..");
		
		return "members/regist";
	}
	
	@PostMapping("regist")
	public String registPost(MemberVo vo,
			RedirectAttributes rttr) throws Exception {
		logger.info("called registPost()");
		
		service.regist(vo);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/members/login";
	}
}
