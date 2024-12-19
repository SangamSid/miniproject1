package com.miniproject.miniproject1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.miniproject.miniproject1.Entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>  {
	@Query(value="select * from Enquiry where counseller_id=:counseller_id",nativeQuery=true)
	public List<Enquiry> getyAllEnquiryByCounsellerId(Integer counseller_id);

}
