package com.it15301.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/admin/users")
public class UserController {
	@Autowired
	private HttpServletRequest request;

	@GetMapping()
	public String index()
	{
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
	public String edit()
	{
		return "admin/users/edit";
	}

	@PostMapping(value="/update/{id}")
	public String update()
	{
		return "redirect:/admin/users";
	}

	@PostMapping(value="/delete/{id}")
	public String delete()
	{
		return "redirect:/admin/users";
	}
}
