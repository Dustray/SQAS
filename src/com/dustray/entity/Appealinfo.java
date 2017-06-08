package com.dustray.entity;

import java.sql.Timestamp;

/**
 * Appealinfo entity. @author MyEclipse Persistence Tools
 */

public class Appealinfo implements java.io.Serializable {

	// Fields

	private Integer aplid;
	private String aplname;
	private Integer aplbrlid;
	private String aplgradeclass;
	private String apldepartment;
	private String aplreason;
	private Timestamp apldate;
	private String aplresult;
	private Timestamp apldisposdate;
	private String apldisposename;

	// Constructors

	/** default constructor */
	public Appealinfo() {
	}

	/** full constructor */
	public Appealinfo(String aplname, Integer aplbrlid, String aplgradeclass,
			String apldepartment, String aplreason, Timestamp apldate,
			String aplresult, Timestamp apldisposdate, String apldisposename) {
		this.aplname = aplname;
		this.aplbrlid = aplbrlid;
		this.aplgradeclass = aplgradeclass;
		this.apldepartment = apldepartment;
		this.aplreason = aplreason;
		this.apldate = apldate;
		this.aplresult = aplresult;
		this.apldisposdate = apldisposdate;
		this.apldisposename = apldisposename;
	}

	// Property accessors

	public Integer getAplid() {
		return this.aplid;
	}

	public void setAplid(Integer aplid) {
		this.aplid = aplid;
	}

	public String getAplname() {
		return this.aplname;
	}

	public void setAplname(String aplname) {
		this.aplname = aplname;
	}

	public Integer getAplbrlid() {
		return this.aplbrlid;
	}

	public void setAplbrlid(Integer aplbrlid) {
		this.aplbrlid = aplbrlid;
	}

	public String getAplgradeclass() {
		return this.aplgradeclass;
	}

	public void setAplgradeclass(String aplgradeclass) {
		this.aplgradeclass = aplgradeclass;
	}

	public String getApldepartment() {
		return this.apldepartment;
	}

	public void setApldepartment(String apldepartment) {
		this.apldepartment = apldepartment;
	}

	public String getAplreason() {
		return this.aplreason;
	}

	public void setAplreason(String aplreason) {
		this.aplreason = aplreason;
	}

	public Timestamp getApldate() {
		return this.apldate;
	}

	public void setApldate(Timestamp apldate) {
		this.apldate = apldate;
	}

	public String getAplresult() {
		return this.aplresult;
	}

	public void setAplresult(String aplresult) {
		this.aplresult = aplresult;
	}

	public Timestamp getApldisposdate() {
		return this.apldisposdate;
	}

	public void setApldisposdate(Timestamp apldisposdate) {
		this.apldisposdate = apldisposdate;
	}

	public String getApldisposename() {
		return this.apldisposename;
	}

	public void setApldisposename(String apldisposename) {
		this.apldisposename = apldisposename;
	}

}