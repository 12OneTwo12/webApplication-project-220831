package com.firstgroup.workerWeb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.firstgroup.workerWeb.command.WorkerVO;
import com.firstgroup.workerWeb.worker.service.WorkerService;

@Controller
//@RequestMapping("/worker") // 들어갈 주소 (파일 이름)
public class WorkerController {

	@Autowired
	@Qualifier("workerService")
	WorkerService workerService;
	
	@RequestMapping("/worker_signUp") // 회원 가입 후 form 값과 함께 받을 주소 
	public String signUp(WorkerVO workerVO, RedirectAttributes RA) {
		
		if(workerService.checkId(workerVO.getWorker_id()) != 0) {
			RA.addFlashAttribute("msg","이미 존재하는 아이디 입니다");
			return "redirect:/"; // 로그인 페이지
		} else {
			int result = workerService.signUp(workerVO);
			if (result == 1) {
				
				RA.addFlashAttribute("msg", "회원 가입을 축하드립니다");
				System.out.println("회원 가입을 축하드립니다");
				
				return "redirect:/login"; // msg와 함께 로그인 페이지로 전송
			} else {
				
				RA.addFlashAttribute("msg", "회원 가입에 실패했습니다");
				System.out.println("회원 가입에 실패했습니다");
				return "redirect:/"; // msg와 함께 로그인 페이지로 전송
			}
		}
		
	}
	
	@RequestMapping("login")
	public void login() {
	}
	
	@RequestMapping("/worker_loginForm")
	public String workerLogin(WorkerVO workerVO, RedirectAttributes RA,  HttpSession session) {
		
		WorkerVO vo = workerService.login(workerVO);
		if(vo != null) {
			session.setMaxInactiveInterval(60000);
			session.setAttribute("sessionVO", vo);
			RA.addFlashAttribute("msg", "로그인 성공");
			return "redirect:/"; // 로그인 성공 후 페이지
		} else {
			RA.addFlashAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다");
			return "redirect:/login";
		}
				
	}
	
}