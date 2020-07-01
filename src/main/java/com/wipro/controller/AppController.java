package com.wipro.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.entity.Request;
import com.wipro.entity.User;
import com.wipro.repository.UserRepository;
import com.wipro.service.RequestService;

@Controller
public class AppController {
	@Autowired
	private RequestService service;

	@Autowired
	private UserRepository userService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		// Getting User
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		final User user = this.userService.getUserByUsername(username);

		List<Request> listRequests = service.listAll();
		List<Request> userRequestList = new ArrayList<Request>();

		if (user.getRoles().iterator().next().getName().equalsIgnoreCase("USER")) {
			userRequestList = service.getValidData(listRequests, user);
			model.addAttribute("listRequests", userRequestList);
		} else if (user.getRoles().iterator().next().getName().equalsIgnoreCase("ADMIN")) {
			model.addAttribute("listRequests", listRequests);
		}
		return "index";

	}

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Request request = new Request();
		model.addAttribute("request", request);

		return "new_request";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRequest(@ModelAttribute("request") Request request) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		Set<User> request_user = new HashSet<User>();
		user.setUsername(((UserDetails) principal).getUsername());
		user = this.userService.getUserByUsername(user.getUsername());
		request_user.add(user);
		request.setRequestUser(request_user);
		service.save(request);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditRequesttForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_request");

		Request request = service.get(id);
		mav.addObject("request", request);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);

		return "redirect:/";
	}
}
