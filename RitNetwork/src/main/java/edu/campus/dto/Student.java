package edu.campus.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student extends RegistrationDTO{

	@Id
	private String usn;
	private String department;
	private String course;
	private int semester;
	private String skills;
	private String hobbies;

	@OneToMany(mappedBy="stud")
	private List<Requests> req = new ArrayList<Requests>();

	@ManyToMany(mappedBy="studReqInterested")
	private List<Requests> reqInterested = new ArrayList<Requests>();

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public List<Requests> getReq() {
		return req;
	}
	public void setReq(List<Requests> req) {
		this.req = req;
	}
	public List<Requests> getReqInterested() {
		return reqInterested;
	}
	public void setReqInterested(List<Requests> reqInterested) {
		this.reqInterested = reqInterested;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", department=" + department + ", course=" + course + ", semester=" + semester
				+ ", skills=" + skills + ", hobbies=" + hobbies + ", req=" + req
				+ ", reqInterested=" + reqInterested + "]";
	}


}
