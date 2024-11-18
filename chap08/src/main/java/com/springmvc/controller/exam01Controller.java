package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class exam01Controller 
{
	@GetMapping("/exam01")
	public String requestMethod(Model model)
	{
		System.out.println("/exam01 - webpage08_01 이동");
		return "webpage08_01";
	}
	
	@GetMapping("/admin/main")
	public String requestMethod2(Model model)
	{
		System.out.println("/admin/main - adminPage 이동");
		model.addAttribute("data", "/adminPage.jsp");
		return "adminPage";
	}
	
	@GetMapping("/manager/main")
	public String requestMethod3(Model model)
	{
		System.out.println("/manager/main - managerPage 이동");
		model.addAttribute("data", "/managerPage.jsp");
		return "managerPage";
	}
	
	@GetMapping("/member/main")
	public String requestMethod4(Model model)
	{
		System.out.println("/member/main - memberPage 이동");
		model.addAttribute("data", "/memberPage.jsp");
		return "memberPage";
	}
	
	@GetMapping("/home/main")
	public String requestMethod5(Model model)
	{
		System.out.println("/home/main - homePage 이동");
		model.addAttribute("data", "/homePage.jsp");
		return "homePage";
	}
}
