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
public class Activities {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int act_id;
	@ManyToOne
	private Student stud;
	@ManyToOne
	private Faculty fac;
	@OneToOne
	private ActPoll poll = null;
	private int approval;
	private String actName;
	private String actDesc;
	@Temporal(TemporalType.TIMESTAMP)
	private Date actpostdate;
	private String actDate;
	private String actEndDate;
	public int getAct_id() {
		return act_id;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
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
	public ActPoll getPoll() {
		return poll;
	}
	public void setPoll(ActPoll poll) {
		this.poll = poll;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public Date getActpostdate() {
		return actpostdate;
	}
	public void setActpostdate(Date actpostdate) {
		this.actpostdate = actpostdate;
	}
	public String getActDate() {
		return actDate;
	}
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	public String getActEndDate() {
		return actEndDate;
	}
	public void setActEndDate(String actEndDate) {
		this.actEndDate = actEndDate;
	}
	
	
}
