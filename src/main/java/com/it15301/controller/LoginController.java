package com.it15301.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it15301.entity.User;
import com.it15301.repositories.UserRepository;
import com.it15301.utilities.HashUtil;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/login")
	public String getLoginForm() {
		return "/auth/login";
	}
	
	@PostMapping("/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		User entity = this.userRepo.findByEmail(email);
		HttpSession session = request.getSession();
		if (entity == null) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "redirect:/login";
		}

		boolean checkPwd = HashUtil.verify(password, entity.getPassword());
		if (!checkPwd) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "redirect:/login";
		}
		
		session.setAttribute("user", entity);
		return "redirect:/admin/users";
	}
}
