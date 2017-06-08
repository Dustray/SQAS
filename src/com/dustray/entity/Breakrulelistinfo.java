package com.dustray.entity;

import java.sql.Timestamp;

/**
 * Breakrulelistinfo entity. @author MyEclipse Persistence Tools
 */

public class Breakrulelistinfo implements java.io.Serializable {

	// Fields

	private Integer brlid;
	private Stuunidepinfo stuunidepinfo;
	private Stuunimeminfo stuunimeminfo;
	private String brltype;
	private String brlstuname;
	private Integer brlstugrade;
	private String brlstuclass;
	private Timestamp brldate;
	private String brldetail;
	private Double brlpoints;
	private String brlpointsunit;
	private Timestamp brldealdate;

	// Constructors

	/** default constructor */
	public Breakrulelistinfo() {
	}

	/** full constructor */
	public Breakrulelistinfo(Stuunidepinfo stuunidepinfo,
			Stuunimeminfo stuunimeminfo, String brltype, String brlstuname,
			Integer brlstugrade, String brlstuclass, Timestamp brldate,
			String brldetail, Double brlpoints, String brlpointsunit,
			Timestamp brldealdate) {
		this.stuunidepinfo = stuunidepinfo;
		this.stuunimeminfo = stuunimeminfo;
		this.brltype = brltype;
		this.brlstuname = brlstuname;
		this.brlstugrade = brlstugrade;
		this.brlstuclass = brlstuclass;
		this.brldate = brldate;
		this.brldetail = brldetail;
		this.brlpoints = brlpoints;
		this.brlpointsunit = brlpointsunit;
		this.brldealdate = brldealdate;
	}

	// Property accessors

	public Integer getBrlid() {
		return this.brlid;
	}

	public void setBrlid(Integer brlid) {
		this.brlid = brlid;
	}

	public Stuunidepinfo getStuunidepinfo() {
		return this.stuunidepinfo;
	}

	public void setStuunidepinfo(Stuunidepinfo stuunidepinfo) {
		this.stuunidepinfo = stuunidepinfo;
	}

	public Stuunimeminfo getStuunimeminfo() {
		return this.stuunimeminfo;
	}

	public void setStuunimeminfo(Stuunimeminfo stuunimeminfo) {
		this.stuunimeminfo = stuunimeminfo;
	}

	public String getBrltype() {
		return this.brltype;
	}

	public void setBrltype(String brltype) {
		this.brltype = brltype;
	}

	public String getBrlstuname() {
		return this.brlstuname;
	}

	public void setBrlstuname(String brlstuname) {
		this.brlstuname = brlstuname;
	}

	public Integer getBrlstugrade() {
		return this.brlstugrade;
	}

	public void setBrlstugrade(Integer brlstugrade) {
		this.brlstugrade = brlstugrade;
	}

	public String getBrlstuclass() {
		return this.brlstuclass;
	}

	public void setBrlstuclass(String brlstuclass) {
		this.brlstuclass = brlstuclass;
	}

	public Timestamp getBrldate() {
		return this.brldate;
	}

	public void setBrldate(Timestamp brldate) {
		this.brldate = brldate;
	}

	public String getBrldetail() {
		return this.brldetail;
	}

	public void setBrldetail(String brldetail) {
		this.brldetail = brldetail;
	}

	public Double getBrlpoints() {
		return this.brlpoints;
	}

	public void setBrlpoints(Double brlpoints) {
		this.brlpoints = brlpoints;
	}

	public String getBrlpointsunit() {
		return this.brlpointsunit;
	}

	public void setBrlpointsunit(String brlpointsunit) {
		this.brlpointsunit = brlpointsunit;
	}

	public Timestamp getBrldealdate() {
		return this.brldealdate;
	}

	public void setBrldealdate(Timestamp brldealdate) {
		this.brldealdate = brldealdate;
	}

}