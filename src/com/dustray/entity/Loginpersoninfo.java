package com.dustray.entity;

/**
 * Loginpersoninfo entity. @author MyEclipse Persistence Tools
 */

public class Loginpersoninfo implements java.io.Serializable {

	// Fields

	private Integer loginperid;
	private Stuunimeminfo stuunimeminfo;
	private String sumpassword;
	private Integer jurisdiction;

	// Constructors

	/** default constructor */
	public Loginpersoninfo() {
	}

	/** full constructor */
	public Loginpersoninfo(Stuunimeminfo stuunimeminfo, String sumpassword,
			Integer jurisdiction) {
		this.stuunimeminfo = stuunimeminfo;
		this.sumpassword = sumpassword;
		this.jurisdiction = jurisdiction;
	}

	// Property accessors

	public Integer getLoginperid() {
		return this.loginperid;
	}

	public void setLoginperid(Integer loginperid) {
		this.loginperid = loginperid;
	}

	public Stuunimeminfo getStuunimeminfo() {
		return this.stuunimeminfo;
	}

	public void setStuunimeminfo(Stuunimeminfo stuunimeminfo) {
		this.stuunimeminfo = stuunimeminfo;
	}

	public String getSumpassword() {
		return this.sumpassword;
	}

	public void setSumpassword(String sumpassword) {
		this.sumpassword = sumpassword;
	}

	public Integer getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(Integer jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

}