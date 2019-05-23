package com.roh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roh.domain.BoardVo;
import com.roh.domain.Criteria;
import com.roh.domain.PageMaker;
import com.roh.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public void home(Model model) {
		model.addAttribute("msg", "환영합니다");
	}
	
	// 브랜치 테스트용 주석 추가
	
	@GetMapping("post")
	public void registGet() {
		logger.info("called registGet()..");
	}
	
	@PostMapping("post")
	public String registPost(BoardVo vo,
			RedirectAttributes rttr) throws Exception {
		logger.info("called registPost()..");
		logger.debug(vo.toString());
		service.regist(vo);
		
		// 리다이렉트 시점에 한번만 데이터 전송
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/boards";
	}
	
//	@GetMapping
//	public String list(Model model) throws Exception {
//		logger.info("called list()..");
//		model.addAttribute("list", service.listAll());
//		
//		return "boards/list";
//	}
	
	@GetMapping
	public String list(Criteria cri, Model model) throws Exception {
		logger.info("called list()..");
		logger.debug("페이징 정보: " + cri.toString());
		model.addAttribute("list", service.listAll(cri));
		PageMaker pageMaker = service.makePage(cri);
		model.addAttribute("pageMaker", pageMaker);
		
		return "boards/list";
	}
	
//	@GetMapping("{bno}")
//	// @PathVariable - URI 에서 구분자 뒤 변수를 받는 애노테이션
//	public String read(@PathVariable("bno") int bno,
//			Model model) throws Exception {
//		logger.info("called read(" + bno + ")..");
//		model.addAttribute(service.read(bno));
//		
//		return "boards/read";
//	}
	
	@GetMapping("{bno}")
	// @PathVariable - URI 에서 구분자 뒤 변수를 받는 애노테이션
	public String read(@PathVariable("bno") int bno,
			// @ModelAttribute - 객체를 뷰까지 전달
			@ModelAttribute("cri") Criteria cri,
			Model model) throws Exception {
		logger.info("called read(" + bno + ")..");
		logger.info("페이징 정보: " + cri.toString());
		model.addAttribute(service.read(bno));
		
		return "boards/read";
	}
	
	@GetMapping("post/{bno}")
	// 별도 수정 페이지 사용, read와 구분을 위해 post/
	public String modifyGet(@PathVariable("bno") int bno,
			@ModelAttribute("cri") Criteria cri,
			Model model) throws Exception {
		logger.info("called modifyGet(" + bno + ")..");
		logger.info("페이징 정보: " + cri.toString());
		model.addAttribute(service.read(bno));

		return "boards/modify";
	}
	
	@PutMapping("{bno}")
	public String modifyPut(@PathVariable("bno") int bno,
			BoardVo vo,
			Criteria cri,
			RedirectAttributes rttr) throws Exception {
		logger.info("called modifyPut(" + bno + ")");
		logger.info("페이징 정보: " + cri.toString());
		service.modify(vo);
		rttr.addFlashAttribute("result", "success");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/boards/" + bno;
	}
	
	@DeleteMapping("{bno}")
	public String remove(@PathVariable("bno") int bno,
			Criteria cri,
			RedirectAttributes rttr) throws Exception {
		logger.info("called remove(" + bno + ")..");
		logger.info("페이징 정보: " + cri.toString());
		service.remove(bno);
		rttr.addFlashAttribute("result", "success");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/boards";
	}
}
