package com.miniproject.miniproject1.service;

import java.util.List;

import com.miniproject.miniproject1.Entity.Enquiry;
import com.miniproject.miniproject1.Entity.ViewEnqFilterReq;

public interface EnquiryService {

	public boolean addEnquiry(Enquiry enq, Integer counsellerId) throws Exception;
	public List<Enquiry> getAllEnquiries(Integer counsellorId);

	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterReq filterReq, Integer counsellorId);

	public Enquiry getEnquriyById(Integer enqId);
}
