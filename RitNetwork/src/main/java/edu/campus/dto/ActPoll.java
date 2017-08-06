package edu.campus.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class ActPoll {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@OneToOne
	private Faculty fac;
	@OneToOne
	private Activities act;
	@ManyToMany
	List<Student> studpositive = new ArrayList<Student>();
	@ManyToMany
	List<Student> studnegetive = new ArrayList<Student>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Faculty getFac() {
		return fac;
	}
	public void setFac(Faculty fac) {
		this.fac = fac;
	}
	public Activities getAct() {
		return act;
	}
	public void setAct(Activities act) {
		this.act = act;
	}
	public List<Student> getStudpositive() {
		return studpositive;
	}
	public void setStudpositive(List<Student> studpositive) {
		this.studpositive = studpositive;
	}
	public List<Student> getStudnegetive() {
		return studnegetive;
	}
	public void setStudnegetive(List<Student> studnegetive) {
		this.studnegetive = studnegetive;
	}
	
}
