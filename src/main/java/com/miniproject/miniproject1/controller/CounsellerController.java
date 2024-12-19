package com.miniproject.miniproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miniproject.miniproject1.Entity.Counseller;
import com.miniproject.miniproject1.Entity.DashboardResponse;
import com.miniproject.miniproject1.service.CounsellerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellerController {
	
	@Autowired
	private CounsellerServiceImpl counsellerServiceImpl;

	@GetMapping("/")
	public String index( Model model ) {
		
		Counseller cobj=new Counseller();
		model.addAttribute("counseller",cobj);
		
		return "index";
	}
	
	@PostMapping("/login")
	public String login( Counseller counseller, Model model,HttpServletRequest request) {
		System.out.println(counseller.getEmail());
	Counseller c1	=counsellerServiceImpl.login(counseller.getEmail(), counseller.getPwd());

	if(c1==null) {
		model.addAttribute("message","Invalid Credentials");
		return "index";
	}else {
		
	HttpSession session=request.getSession(true);
	session.setAttribute("counsellerId", c1.getCounseller_id());
		
		DashboardResponse dashboardInfo= counsellerServiceImpl.getDashboardInfo(c1.getCounseller_id());
		model.addAttribute("dashboardInfo",dashboardInfo);
	System.out.println(dashboardInfo.toString());
		return "viewDashboard";
	}
	
		
}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
	HttpSession session=	request.getSession(false);
	session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register( Model model) {
		Counseller cobj=new Counseller();
		
		model.addAttribute("counseller",cobj);
		return "register";
	}
	
	@PostMapping("/register")
	public String registersave(Model model,Counseller counseller) {
		
		boolean isRegister=	counsellerServiceImpl.registerCounseller(counseller);
		
			if(!isRegister) {
			model.addAttribute("errormessage","Not able to register");
		}
			else {
			model.addAttribute("successmessage","registered successfully");
		}
		
		
		return "register";
	}
//	
//	

//	
	
	
}
