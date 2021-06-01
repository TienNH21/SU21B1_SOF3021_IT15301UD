package com.it15301.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.it15301.dto.User;
import com.it15301.repositories.UserRepository;

@Controller
@RequestMapping(value="/admin/users")
public class UserController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping()
	public String index(Model model)
	{
		List<com.it15301.entity.User> listUser = this.userRepo.findAll();
		
		model.addAttribute("listUser", listUser);
		
		return "admin/users/index";
	}

	@GetMapping(value="{id}")
	public String show(
		Model model,
		@PathVariable("id") Integer id
	) {
		System.out.println("id: " + id);
		
		model.addAttribute("id", id);

		return "admin/users/show";
	}

	@GetMapping(value="/create")
	public String create()
	{
		return "admin/users/create";
	}

	@PostMapping(value="/store")
	public String store()
	{
		return "redirect:/admin/users";
	}

	@GetMapping(value="/edit/{id}")
	public String edit(Model model)
	{
		User user = new User();
		
		user.setId(1);
		user.setName("Nguyễn Văn A");
		user.setStudentCode("PH12321");
		user.setEmail("anvph12321@fpt.edu.vn");
		user.setPassword("123456");
		user.setDob(new Date(1990, 3, 20));
		user.setAvatar("");
		user.setRole(1);
		user.setGender(1);
		user.setStatus(1);
		
		model.addAttribute("user", user);
		
		System.out.println("Version: " + SpringVersion.getVersion());
		
		return "admin/users/edit";
	}

	@PostMapping(value="/update/{id}")
	public String update(
		Model model,
		@Valid User user,
		BindingResult result
	) {
		if (result.hasErrors()) {
			System.out.println("Có lỗi");
//			return "redirect:/admin/users/edit/1";
			model.addAttribute("errors", result.getAllErrors());
			return "admin/users/edit";
		} else {
			System.out.println("Ko Có lỗi");
			return "redirect:/admin/users";
		}
	}

	@PostMapping(value="/delete/{id}")
	public String delete()
	{
		return "redirect:/admin/users";
	}
}
