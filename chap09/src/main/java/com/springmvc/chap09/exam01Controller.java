package com.springmvc.chap09;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/exam01")
public class exam01Controller 
{
	@GetMapping("/form")
	public String requestForm()
	{
		System.out.println("컨트롤러 - 폼으로 이동");
		return "webpage09_01";
	}
	
	@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name, @RequestParam("fileImage") MultipartFile file)
	{
		System.out.println("컨트롤러 - 제출폼 함수 입장");
		String filename = file.getOriginalFilename();
		System.out.println("파일명 : "+filename);
		File f = new File("c:\\upload\\"+name+"_"+filename);	//빈 파일 만들기
		
		try
		{
			System.out.println("submitForm try");
			file.transferTo(f);	//파일 작성해줌
		}
		catch(Exception e)
		{
			System.out.println("submitForm 캐치 에러에러");
			e.printStackTrace();
		}
		System.out.println("submitForm 끝 . 제출 뷰로 이동");
		return "webpage09_submit";
	}
}
