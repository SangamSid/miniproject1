package com.miniproject.miniproject1.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Counseller {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer counseller_id;
		private String name;
		private String email;
		private String pwd;
		private Long phno;
		@CreationTimestamp
		private LocalDate created_date;
		@UpdateTimestamp
		private LocalDate updated_date;
		
		
		
		public Counseller() {
			super();
		}
		public Counseller(Integer counseller_id, String name, String email, String pwd, Long phno, LocalDate created_date,
				LocalDate updated_date) {
			super();
			this.counseller_id = counseller_id;
			this.name = name;
			this.email = email;
			this.pwd = pwd;
			this.phno = phno;
			this.created_date = created_date;
			this.updated_date = updated_date;
		}
		public Integer getCounseller_id() {
			return counseller_id;
		}
		public void setCounseller_id(Integer counseller_id) {
			this.counseller_id = counseller_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public Long getPhno() {
			return phno;
		}
		public void setPhno(Long phno) {
			this.phno = phno;
		}
		public LocalDate getCreated_date() {
			return created_date;
		}
		public void setCreated_date(LocalDate created_date) {
			this.created_date = created_date;
		}
		public LocalDate getUpdated_date() {
			return updated_date;
		}
		public void setUpdated_date(LocalDate updated_date) {
			this.updated_date = updated_date;
		}
	
}
