package edu.campus.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;


@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int ques_id;
	@OneToOne
	private Student stud;
	@OneToMany(mappedBy="ques")
	private List<Q_answers> ans = new ArrayList<Q_answers>();
	private String question;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ques_time;
	
	public List<Q_answers> getAns() {
		return ans;
	}
	public void setAns(List<Q_answers> ans) {
		this.ans = ans;
	}
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getQues_time() {
		return ques_time;
	}
	public void setQues_time(Date ques_time) {
		this.ques_time = ques_time;
	}
	@Override
	public String toString() {
		return "Questions [ques_id=" + ques_id + ", stud=" + stud + ", ans=" + ans + ", question=" + question
				+ ", ques_time=" + ques_time + "]";
	}
}
