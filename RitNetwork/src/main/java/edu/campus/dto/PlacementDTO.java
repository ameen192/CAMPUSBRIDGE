package edu.campus.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PlacementDTO {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int plc_id;
	private String compName;
	private String lpa;
	private String criteria;
	@Temporal(TemporalType.TIMESTAMP)
	private Date plc_date;
	private String fid;
	
	public int getPlc_id() {
		return plc_id;
	}
	public void setPlc_id(int plc_id) {
		this.plc_id = plc_id;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getLpa() {
		return lpa;
	}
	public void setLpa(String lpa) {
		this.lpa = lpa;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public Date getPlc_date() {
		return plc_date;
	}
	public void setPlc_date(Date plc_date) {
		this.plc_date = plc_date;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
}
