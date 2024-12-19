package com.miniproject.miniproject1.repository;

import org.springframework.data.repository.CrudRepository;

import com.miniproject.miniproject1.Entity.Counseller;

public interface CounsellerRepo extends CrudRepository<Counseller, Integer> {
	public Counseller findByEmailAndPwd(String emailId,String pwd);
}
