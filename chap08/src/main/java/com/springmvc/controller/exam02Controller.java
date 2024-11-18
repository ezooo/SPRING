package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class exam02Controller 
{
	@GetMapping("/exam02")
	public String requestMethod(Model model)
	{
		System.out.println("/exam02 - webpage08_02 이동");
		return "webpage08_02";
	}
	
	@GetMapping("/manager/tag")
	public String requestMethod2(Model model)
	{
		System.out.println("/admin/tag - webpage08_02 이동");
		return "webpage08_02";
	}
}
