package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bo.UserBO;
import com.example.domain.User;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	UserBO userBO;

	@Autowired
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Home page requested");
		// get a list of all users
		List<User> userList = userBO.getUserList();
		// add to session
		model.addAttribute("userList", userList);
		model.addAttribute("userForm", new User());
		// return home.jsp
		return "home";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		logger.info("About page requested");
		// return about.jsp
		return "about";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		logger.info("About page requested");
		// return contact.jsp
		return "contact";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("userForm") User user,
			BindingResult result) {
		// create new user
		try {
			userBO.createUser(user);
		} catch (Exception e) {
			System.out.println("Save Failed!");
			return "redirect:/";
		}
		// redirect to root
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("userId") int userId) {
		// delete user
		userBO.deleteUser(userId);
		// redirect to root
		return "redirect:/";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,
			BindingResult result) {
		// update user
		try {
			userBO.updateUser(user);
		} catch (Exception e) {
			System.out.println("Update Failed!");
			return "redirect:/";
		}
		// redirect to root
		return "redirect:/";
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public String getUser(Model model, @PathVariable String username) {
		// get user by name
		User user = userBO.getUserByUserName(username);
		// add to session
		model.addAttribute("user", user);
		// return user.jsp
		return "user";
	}

}
