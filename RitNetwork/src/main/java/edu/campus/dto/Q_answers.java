package edu.campus.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Q_answers {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int ansId;
	@ManyToOne
	private Questions ques;
	@OneToOne
	private Student stud;
	@OneToOne
	private Faculty fac;
	private String user_type;
	private String answer_desc;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ans_time;
	
	public Questions getQues() {
		return ques;
	}
	public void setQues(Questions ques) {
		this.ques = ques;
	}
	
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	public Faculty getFac() {
		return fac;
	}
	public void setFac(Faculty fac) {
		this.fac = fac;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getAnswer_desc() {
		return answer_desc;
	}
	public void setAnswer_desc(String answer_desc) {
		this.answer_desc = answer_desc;
	}
	public Date getAns_time() {
		return ans_time;
	}
	public void setAns_time(Date ans_time) {
		this.ans_time = ans_time;
	}
	
}
