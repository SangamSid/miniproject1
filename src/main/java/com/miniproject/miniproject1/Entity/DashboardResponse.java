package com.miniproject.miniproject1.Entity;

public class DashboardResponse {
	
	
	private Integer total_enquiry;
	private Integer open_enquiry;
	private Integer enrolled_enquiry;
	private Integer lost_enquiry;
	
	
	public DashboardResponse(Integer total_enquiry, Integer open_enquiry, Integer enrolled_enquiry,
			Integer lost_enquiry) {
		super();
		this.total_enquiry = total_enquiry;
		this.open_enquiry = open_enquiry;
		this.enrolled_enquiry = enrolled_enquiry;
		this.lost_enquiry = lost_enquiry;
	}
	public DashboardResponse() {
		super();
	}
	public Integer getTotal_enquiry() {
		return total_enquiry;
	}
	public void setTotal_enquiry(Integer total_enquiry) {
		this.total_enquiry = total_enquiry;
	}
	public Integer getOpen_enquiry() {
		return open_enquiry;
	}
	public void setOpen_enquiry(Integer open_enquiry) {
		this.open_enquiry = open_enquiry;
	}
	public Integer getEnrolled_enquiry() {
		return enrolled_enquiry;
	}
	public void setEnrolled_enquiry(Integer enrolled_enquiry) {
		this.enrolled_enquiry = enrolled_enquiry;
	}
	public Integer getLost_enquiry() {
		return lost_enquiry;
	}
	public void setLost_enquiry(Integer lost_enquiry) {
		this.lost_enquiry = lost_enquiry;
	}
	@Override
	public String toString() {
		return "DashboardResponse [total_enquiry=" + total_enquiry + ", open_enquiry=" + open_enquiry
				+ ", enrolled_enquiry=" + enrolled_enquiry + ", lost_enquiry=" + lost_enquiry + "]";
	}

	
	
}
