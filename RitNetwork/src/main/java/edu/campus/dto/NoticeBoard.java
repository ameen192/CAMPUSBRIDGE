package edu.campus.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NoticeBoard {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int notice_id;
	@OneToOne
	private Faculty fac;
	private String notice_desc;
	@Temporal(TemporalType.TIMESTAMP)
	private Date notice_date;
	private String notice_dept;
	private String notice_course;
	private String notice_sem;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public Faculty getFac() {
		return fac;
	}
	public void setFac(Faculty fac) {
		this.fac = fac;
	}
	public String getNotice_desc() {
		return notice_desc;
	}
	public void setNotice_desc(String notice_desc) {
		this.notice_desc = notice_desc;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_dept() {
		return notice_dept;
	}
	public void setNotice_dept(String notice_dept) {
		this.notice_dept = notice_dept;
	}
	public String getNotice_course() {
		return notice_course;
	}
	public void setNotice_course(String notice_course) {
		this.notice_course = notice_course;
	}
	public String getNotice_sem() {
		return notice_sem;
	}
	public void setNotice_sem(String notice_sem) {
		this.notice_sem = notice_sem;
	}
	
	
}
