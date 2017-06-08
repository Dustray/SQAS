package com.dustray.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Stuunidepinfo entity. @author MyEclipse Persistence Tools
 */

public class Stuunidepinfo implements java.io.Serializable {

	// Fields

	private Integer sudid;
	private String sudname;
	private Set stuunimeminfos = new HashSet(0);
	private Set breakrulelistinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Stuunidepinfo() {
	}

	/** full constructor */
	public Stuunidepinfo(String sudname, Set stuunimeminfos,
			Set breakrulelistinfos) {
		this.sudname = sudname;
		this.stuunimeminfos = stuunimeminfos;
		this.breakrulelistinfos = breakrulelistinfos;
	}

	// Property accessors

	public Integer getSudid() {
		return this.sudid;
	}

	public void setSudid(Integer sudid) {
		this.sudid = sudid;
	}

	public String getSudname() {
		return this.sudname;
	}

	public void setSudname(String sudname) {
		this.sudname = sudname;
	}

	public Set getStuunimeminfos() {
		return this.stuunimeminfos;
	}

	public void setStuunimeminfos(Set stuunimeminfos) {
		this.stuunimeminfos = stuunimeminfos;
	}

	public Set getBreakrulelistinfos() {
		return this.breakrulelistinfos;
	}

	public void setBreakrulelistinfos(Set breakrulelistinfos) {
		this.breakrulelistinfos = breakrulelistinfos;
	}

}