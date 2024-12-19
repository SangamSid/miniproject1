package com.miniproject.miniproject1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.miniproject.miniproject1.Entity.Counseller;
import com.miniproject.miniproject1.Entity.DashboardResponse;
import com.miniproject.miniproject1.Entity.Enquiry;
import com.miniproject.miniproject1.repository.CounsellerRepo;
import com.miniproject.miniproject1.repository.EnquiryRepo;

@Service
public class CounsellerServiceImpl implements CounsellerService {

	
	@Autowired
	public CounsellerRepo counsellerRepo;

	@Autowired
	public EnquiryRepo enquiryRepo;

	@Override
	public boolean registerCounseller( Counseller counseller) {
		// TODO Auto-generated method stub
	Counseller saveCounseller=	counsellerRepo.save(counseller);
		if(saveCounseller.getCounseller_id()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Counseller login(String email, String password) {
		// TODO Auto-generated method stub
		
	Counseller counseller=	counsellerRepo.findByEmailAndPwd(email,password);


		return counseller;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counseller_id) {
		// TODO Auto-generated method stub
	List<Enquiry>enquiries=	enquiryRepo.getyAllEnquiryByCounsellerId(counseller_id);
	for (Enquiry enquiry : enquiries) {
	System.out.println(enquiry.getEnq_status());
	}
	
	DashboardResponse dashboardResponse=new DashboardResponse();
	
	Integer total_enquiry=enquiries.size();
	dashboardResponse.setTotal_enquiry(total_enquiry);
	
	
	Integer open_enq=enquiries.stream().filter(e->e.getEnq_status().equals("Open")).collect(Collectors.toList()).size();
	dashboardResponse.setOpen_enquiry(open_enq);
	
	Integer enrolled_enq=enquiries.stream().filter(e->e.getEnq_status().equals("Enrolled")).collect(Collectors.toList()).size();
	System.out.println(enrolled_enq);
	dashboardResponse.setEnrolled_enquiry(enrolled_enq);
	
	Integer lost_enq=enquiries.stream().filter(e->e.getEnq_status().equals("Lost")).collect(Collectors.toList()).size();
	dashboardResponse.setLost_enquiry(lost_enq);
		
		return dashboardResponse;
	}
	
	
	
	
}
