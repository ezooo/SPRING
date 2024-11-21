package com.springmvc.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/exam01")
public class exam01Controller2 
{
	@GetMapping("/json")
	public String showForm()
	{
		System.out.println("showform in");
		return "webpage14_02";
	}
	
	@PostMapping("/test")
	public void submit(@RequestBody HashMap<String, Object> map)
	{
		System.out.println("submit function in");
		System.out.println(map);
	}
}
