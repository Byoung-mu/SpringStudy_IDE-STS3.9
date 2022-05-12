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
		log.info("�Խ��� ��� ������ ����");
	}
	
	//=>@RequestMapping(value="enroll" , method = RequestMethod.GET)
	@GetMapping("/enroll")
	public void boardEntollGET() {
		log.info("�Խ��� ��� ������ ����");
	}
	
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board , RedirectAttributes rttr) {
		log.info("BoardVO : " + board);
		bservice.enroll(board);
		rttr.addFlashAttribute("result","enrol success");
		
		// �����̷�Ʈ(Redirect) ������� ����������� �̵��ϴ� ������ '���', '����', '����' 
		// ���� �۾��� ó���� �� �� "���ΰ�ħ"�� ���� ������ ������ ��� ������ ����� �� ���� �ϱ� �����Դϴ�.
		return "redirect:/board/list";
		
	}
}
