package com.BK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BK.model.BoardVO;
import com.BK.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	//=>@RequestMapping(value="list" , method = RequestMethod.GET)
	@GetMapping("/list")
	public void boardListGET() {
		log.info("게시판 목록 페이지 진입");
	}
	
	//=>@RequestMapping(value="enroll" , method = RequestMethod.GET)
	@GetMapping("/enroll")
	public void boardEntollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board , RedirectAttributes rttr) {
		log.info("BoardVO : " + board);
		bservice.enroll(board);
		rttr.addFlashAttribute("result","enrol success");
		
		// 리다이렉트(Redirect) 방식으로 목록페이지로 이동하는 이유는 '등록', '수정', '삭제' 
		// 같은 작업이 처리가 된 후 "새로고침"을 통해 동일한 내용을 계속 서버에 등록할 수 없게 하기 위함입니다.
		return "redirect:/board/list";
		
	}
}
