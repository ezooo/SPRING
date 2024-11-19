package com.springmvc.chap09;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class exam03Controller 
{
	@GetMapping("/form")
	public String requestForm(Member member)
	{
		System.out.println("03 컨트롤러 - 폼으로 이동");
		return "webpage09_03";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute("member") Member member, HttpServletRequest request, HttpSession ssn)
	{
		System.out.println("exam03 - submitForm enter");
		String name = member.getName();
		String filename = member.getImageFile().getOriginalFilename();	//1.파일 이름 만들기
		String savepath = request.getServletContext().getRealPath("/resources/images");
		System.out.println(savepath);
		File f = new File(savepath +"/"+name+"_"+filename);	//2.비어있는 파일 생성
		try 
		{
			System.out.println("exam03 - submitForm - try");
			member.getImageFile().transferTo(f);	//빈 파일에 내용 작성
		} 
		catch (Exception e) 
		{
			System.out.println("exam03 - submitForm - catch error");
			e.printStackTrace();
		}
		System.out.println("exam03 - submitForm end - 제출뷰로 이동");
		return "webpage09_submit";
	}
}
