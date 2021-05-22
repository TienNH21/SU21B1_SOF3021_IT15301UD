package com.it15301.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it15301.entity.User;

@Controller
public class HelloController {
	@RequestMapping("/hello")
//	@ModelAttribute
//	public String hello(@ModelAttribute)
	public String hello(Model model)
	{
//		User user = new User();
//		user.setName("Nguyen Van A");
		String message = "Hello học lại";
		model.addAttribute("message", message);
		return "hello";
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "forward:/hello";
	}

	@ResponseBody
	@GetMapping("/demo-api")
	public String demoApi()
	{
		return "Ko học lại";
	}
}
