package edu.campus.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends RegistrationDTO{
	private String department;
	private String subjects;
	@Id
	private String faculty_coll_id;
	@OneToMany(mappedBy="fac")
	private List<Response> resp = new ArrayList<Response>();
	
	
	
	public String getFaculty_coll_id() {
		return faculty_coll_id;
	}
	public void setFaculty_coll_id(String faculty_coll_id) {
		this.faculty_coll_id = faculty_coll_id;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Response> getResp() {
		return resp;
	}
	public void setResp(List<Response> resp) {
		this.resp = resp;
	}
	@Override
	public String toString() {
		return "Faculty [department=" + department + ", subjects=" + subjects + ", faculty_coll_id=" + faculty_coll_id
				+ ", resp=" + resp + ", getFaculty_coll_id()=" + getFaculty_coll_id() + ", getSubjects()="
				+ getSubjects() + ", getDepartment()=" + getDepartment() + ", getResp()=" + getResp() + ", getName()="
				+ getName() + ", getPassword()=" + getPassword() + ", getGender()=" + getGender() + ", getEmail()="
				+ getEmail() + ", getType()=" + getType() + ", getAbout()=" + getAbout() + ", getVerified()="
				+ getVerified() + ", getPic()=" + getPic() + ", getPhoneNo()=" + getPhoneNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}

