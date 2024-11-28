package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String login()
	{
		System.out.println("로그인 매핑");
		return "login";
	}
	
	@GetMapping("/loginfailed")
	public String loginerror(Model model)
	{
		System.out.println("로그인 실패");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model)
	{
		System.out.println("로그아웃 매핑");
		return "login";
	}
}
