package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class exam01Controller 
{
	@GetMapping
	public String showForm()
	{
		return "webpage14_01";
	}
	
//	@PostMapping
//	public String submit(@RequestMapping)
//	{
//		
//	}
}
