package com.it15301.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it15301.entity.User;
import com.it15301.utilities.UploadFileUtils;

@Controller
public class HelloController {
	@Autowired
	private ServletContext app;
	
	@Autowired
	private UploadFileUtils uploadUtil;

	@RequestMapping("/hello")
	public String hello(Model model)
	{
		System.out.println(this.app.getRealPath(""));
		String message = "Hello học lại";
		model.addAttribute("message", message);
		return "hello";
	}
	
	@PostMapping("/upload-hello")
	public String uploadFileHello(
		@RequestParam("upload_file") MultipartFile uploadedFile
	) {
		this.uploadUtil.handleUploadFile(uploadedFile);
		System.out.println(this.app.getRealPath(""));
		return "redirect:/hello";
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
