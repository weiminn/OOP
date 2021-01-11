package com.smuxoopg1t2.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

	/**
     * login page
     * @param model
     * @return login
     */
	@GetMapping("/login")
	public String login(Model model){
		return "login";
	}

	/**
     * dashboard page
     * @param session
     * @return "redirect:/login" | "dashboard"
     */
	@GetMapping(value={"/dashboard","/"})
	public String dashboard(HttpSession session) {
		String returnValue = (session.getAttribute("token") == null)
							 ? "redirect:/login"
							 : "dashboard";

		return returnValue;
	}

	/**
     * favourites page
     * @param session
     * @return "redirect:/login" | "favourite"
     */
	@GetMapping("/favourites")
	public String favourites(HttpSession session){
		String returnValue = (session.getAttribute("token") == null)
							 ? "redirect:/login"
							 : "favourites";

		return returnValue;
	}

	/**
     * subscription page
     * @param session
     * @return "redirect:/login" | "subscription"
     */
	@GetMapping("/subscription")
	public String subscription(HttpSession session){
		String returnValue = (session.getAttribute("token") == null)
							 ? "redirect:/login"
							 : "subscription";

		return returnValue;
	}

	/**
     * reset password logged in page
     * @param session
     * @return "redirect:/login" | "resetPasswordLoggedIn"
     */
	@GetMapping ("/resetPasswordLoggedIn")
	public String resetPasswordLoggedIn(HttpSession session){
		String returnValue = (session.getAttribute("token") == null)
							 ? "redirect:/login"
							 : "resetPasswordLoggedIn";
		return returnValue;
	}

	/**
     * logout page
     * @param session
     * @return "login"
     */
	@GetMapping("/logout")
	public String logout(HttpSession session){
		System.out.println("Entered");
		session.removeAttribute("token");
		session.removeAttribute("name");
		session.removeAttribute("id");
		return "login";
	}

	/**
     * reset password page
     * @param model
     * @return "resetPassword"
     */
	@GetMapping("/resetPassword")
	public String resetPassword(Model model){
		return "resetPassword";
	}

	/**
     * post reset password page
     * @param model
     * @return "postResetPassword"
     */
	@GetMapping("/postResetPassword")
	public String postResetPassword(Model model){
		return "postResetPassword";
	}

	/**
     * register page
     * @param model
     * @return "register"
     */
	@GetMapping("/register")
	public String register(Model model){
		return "register";
	}

	/**
     * Update password page
     * @param model
     * @return "passwordUpdate"
     */
	@GetMapping ("/passwordUpdate")
	public String passwordUpdate(Model model){
		return "passwordUpdate";
	}
}