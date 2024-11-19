package com.springmvc.chap09;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/exam02")
public class exam02Controller 
{
	@GetMapping("/form")
	public String requestForm()
	{
		System.out.println("02 컨트롤러 - 폼으로 이동");
		return "webpage09_01";
	}
	
	@PostMapping("/form")
	public String submitForm(MultipartHttpServletRequest request)
	{
		System.out.println("ex02 submitform");
		String name = request.getParameter("name");
		MultipartFile file = request.getFile("fileImage");
		String filename = file.getOriginalFilename();
		String savepath = request.getServletContext().getRealPath("/resources/images");
		System.out.println(savepath);
		File f = new File(savepath +"/" +name+"_"+filename);
		System.out.println("empty file 생성완료");
		try 
		{
			System.out.println("try 파일 내용작성");
			file.transferTo(f);
		}
		catch (Exception e) 
		{
			System.out.println("캐치 에러에러");
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
