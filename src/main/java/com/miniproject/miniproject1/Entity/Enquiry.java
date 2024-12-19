package com.miniproject.miniproject1.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Enquiry {
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer enquiry_id;
		private String student_name;
		private Long student_phno;
		private String course_name;
		private String class_mode;
		private String enq_status;
		@CreationTimestamp
		private LocalDate created_date;
		@UpdateTimestamp
		private LocalDate updated_date;
		
		@ManyToOne
		@JoinColumn(name="counseller_id")
		private Counseller counseller;

		public Integer getEnquiry_id() {
			return enquiry_id;
		}

		public void setEnquiry_id(Integer enquiry_id) {
			this.enquiry_id = enquiry_id;
		}

		public String getStudent_name() {
			return student_name;
		}

		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}

		public Long getStudent_phno() {
			return student_phno;
		}

		public void setStudent_phno(Long student_phno) {
			this.student_phno = student_phno;
		}

		public String getCourse_name() {
			return course_name;
		}

		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}

		public String getClass_mode() {
			return class_mode;
		}

		public void setClass_mode(String class_mode) {
			this.class_mode = class_mode;
		}

		public String getEnq_status() {
			return enq_status;
		}

		public void setEnq_status(String enq_status) {
			this.enq_status = enq_status;
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

		public Counseller getCounseller() {
			return counseller;
		}

		public void setCounseller(Counseller counseller) {
			this.counseller = counseller;
		}

		public Enquiry(Integer enquiry_id, String student_name, Long student_phno, String course_name, String class_mode,
				String enq_status, LocalDate created_date, LocalDate updated_date, Counseller counseller) {
			super();
			this.enquiry_id = enquiry_id;
			this.student_name = student_name;
			this.student_phno = student_phno;
			this.course_name = course_name;
			this.class_mode = class_mode;
			this.enq_status = enq_status;
			this.created_date = created_date;
			this.updated_date = updated_date;
			this.counseller = counseller;
		}

		public Enquiry() {
			super();
		}
		
}
