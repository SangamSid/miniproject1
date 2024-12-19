package com.miniproject.miniproject1.service;

import com.miniproject.miniproject1.Entity.Counseller;
import com.miniproject.miniproject1.Entity.DashboardResponse;

public interface CounsellerService {
	
	public boolean registerCounseller( Counseller counseller);
	public Counseller login( String email, String password);
	
	public DashboardResponse getDashboardInfo(Integer counseller_id);

}
