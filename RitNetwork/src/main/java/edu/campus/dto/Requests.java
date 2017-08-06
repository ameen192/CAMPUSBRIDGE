package edu.campus.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Requests {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int reqID;
	@ManyToOne
	private Student stud;
	private String req_title;
	@Temporal(TemporalType.TIMESTAMP)
	private Date req_date;
	@ManyToMany
	private List<Student> studReqInterested = new ArrayList<Student>();
	@OneToOne
	private Response resp = null;
	
	public int getReqID() {
		return reqID;
	}
	public void setReqID(int reqID) {
		this.reqID = reqID;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	public String getReq_title() {
		return req_title;
	}
	public void setReq_title(String req_title) {
		this.req_title = req_title;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}
	public String getReq_desc() {
		return req_desc;
	}
	public void setReq_desc(String req_desc) {
		this.req_desc = req_desc;
	}
	private String req_desc;

	public List<Student> getStudReqInterested() {
		return studReqInterested;
	}
	public void setStudReqInterested(List<Student> studReqInterested) {
		this.studReqInterested = studReqInterested;
	}
	public Response getResp() {
		return resp;
	}
	public void setResp(Response resp) {
		this.resp = resp;
	}
	@Override
	public String toString() {
		return "Requests [reqID=" + reqID + ", req_title=" + req_title + ", req_date=" + req_date + ", req_desc="
				+ req_desc + "]";
	}
	
	
	
}
