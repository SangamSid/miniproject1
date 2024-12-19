package com.miniproject.miniproject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniproject.miniproject1.Entity.DashboardResponse;
import com.miniproject.miniproject1.Entity.Enquiry;
import com.miniproject.miniproject1.Entity.ViewEnqFilterReq;
import com.miniproject.miniproject1.service.CounsellerServiceImpl;
import com.miniproject.miniproject1.service.EnquiryServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryServiceImpl enquiryServiceImpl;
	
	@Autowired
	private CounsellerServiceImpl counsellerServiceImpl;
	
	
	@GetMapping("/editEnquiry")
	public String editEnquiry(@RequestParam("enqId") Integer enqId, Model model ) {
	Enquiry enquiry=	enquiryServiceImpl.getEnquriyById(enqId);
		
		model.addAttribute("enquiry",enquiry);
		
		
		return "addEnquiry";
	}
	
	
	@GetMapping("/addEnquiry")
	public String addEnquiry(Model model ) {
		
		Enquiry enq=new Enquiry();
		
		model.addAttribute("enquiry",enq);
		
		
		return "addEnquiry";
	}
	
	
	
	
	@PostMapping("/addEnquiry")
	public String addEnquiry(Model model,Enquiry enquiry,HttpServletRequest req) throws Exception {
		
	HttpSession session=	req.getSession(false);
Integer counseller_id=	(Integer) session.getAttribute("counsellerId");
		
	boolean isEnquiryAdded=	enquiryServiceImpl.addEnquiry(enquiry, counseller_id);
	if(isEnquiryAdded) {
		model.addAttribute("smsg","Enquiry added successfully");
		return "addEnquiry";
	}else {
		model.addAttribute("emsg","Failed in adding Enquiry");	
		return "addEnquiry";
	}
		
		
		
	}
	
	@GetMapping("/viewDashboard")
	public String viewDashboard( Model model, HttpServletRequest req) {
		
		HttpSession session=	req.getSession(false);
		Integer counseller_id=	(Integer) session.getAttribute("counsellerId");
	DashboardResponse dashObj=	counsellerServiceImpl.getDashboardInfo(counseller_id);
	System.out.println(dashObj.toString());
	model.addAttribute("dashboardInfo",dashObj);
	
		return "ViewDashboard";
	}	
	

	
	
	@GetMapping("/viewEnquiry")
	public String viewEnquiry(Model model,HttpServletRequest req ) {
		
	HttpSession session=	req.getSession(false);
	Integer counseller_id=	(Integer) session.getAttribute("counsellerId");
	
	ViewEnqFilterReq viewEnqFilterReqObj=new ViewEnqFilterReq();
	model.addAttribute("viewEnqFilterReq",viewEnqFilterReqObj);
	
	List<Enquiry>enquiries=	enquiryServiceImpl.getAllEnquiries(counseller_id);
	model.addAttribute("enquiries",enquiries);

		return "viewEnquiry";
	}
	
	@PostMapping("/viewEnquiry")
	public String handleFilter(Model model,HttpServletRequest req,ViewEnqFilterReq viewEnqFilterReq ) {
		
	HttpSession session=	req.getSession(false);
	Integer counseller_id=	(Integer) session.getAttribute("counsellerId");
	
	
	
List<Enquiry>enquiries=	enquiryServiceImpl.getEnquiresWithFilter(viewEnqFilterReq, counseller_id);
model.addAttribute("enquiries",enquiries);

		return "viewEnquiry";
	}
	
	
	
}
