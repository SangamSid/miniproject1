package com.miniproject.miniproject1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.miniproject.miniproject1.Entity.Counseller;
import com.miniproject.miniproject1.Entity.Enquiry;
import com.miniproject.miniproject1.Entity.ViewEnqFilterReq;
import com.miniproject.miniproject1.repository.CounsellerRepo;
import com.miniproject.miniproject1.repository.EnquiryRepo;


import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	public EnquiryRepo enquiryRepo;
	
	@Autowired
	public CounsellerRepo counsellerRepo;

	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellerId) throws Exception {
		
	Counseller counseller=	counsellerRepo.findById(counsellerId).orElse(null);
	
	if(counseller==null) {
		throw new Exception("No counseller found");
	}
		enq.setCounseller(counseller);
	Enquiry saveEnquiry=	enquiryRepo.save(enq);
		
	if(saveEnquiry.getEnquiry_id()!=null) {
		return true;
	}
	
		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellerId) {
	List<Enquiry> enquiries=	enquiryRepo.getyAllEnquiryByCounsellerId(counsellerId);
		return enquiries;
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterReq filterReq, Integer counsellorId) {
//		Query By Example(Dynamic Query Preparation)
		
	
		Enquiry enq=new Enquiry();
//		Dynamic query preparation
			if(StringUtils.isNotEmpty(filterReq.getClass_mode())) {
				enq.setClass_mode(filterReq.getClass_mode());
			}
			if(StringUtils.isNotEmpty(filterReq.getCourse_name())) {
						enq.setCourse_name(filterReq.getCourse_name());
					}
			if(StringUtils.isNotEmpty(filterReq.getEnq_status())) {
				enq.setEnq_status(filterReq.getEnq_status());
			}
			
		Counseller c=		counsellerRepo.findById(counsellorId).orElse(null);
		enq.setCounseller(c);
			Example<Enquiry>of=Example.of(enq);
		
		List<Enquiry>enquiries=	enquiryRepo.findAll(of);
			return enquiries;
		
	
	}

	@Override
	public Enquiry getEnquriyById(Integer enqId) {
		
		return enquiryRepo.findById(enqId).orElse(null);
	}
	
	
	
}
