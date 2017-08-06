package edu.campus.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Response {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int resp_id;
	@ManyToOne
	private Faculty fac;
	private String resp;
	private String allot_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date resDate;
	
	public int getResp_id() {
		return resp_id;
	}
	public void setResp_id(int resp_id) {
		this.resp_id = resp_id;
	}
	public Faculty getFac() {
		return fac;
	}
	public void setFac(Faculty fac) {
		this.fac = fac;
	}
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	public String getAllot_date() {
		return allot_date;
	}
	public void setAllot_date(String allot_date) {
		this.allot_date = allot_date;
	}
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	
}
