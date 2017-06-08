package com.dustray.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Stuunimeminfo entity. @author MyEclipse Persistence Tools
 */

public class Stuunimeminfo implements java.io.Serializable {

	// Fields

	private Integer sumid;
	private Stuunidepinfo stuunidepinfo;
	private Integer sumsid;
	private String sumname;
	private Integer sumgrade;
	private String sumposition;
	private Set loginpersoninfos = new HashSet(0);
	private Set breakrulelistinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Stuunimeminfo() {
	}

	/** full constructor */
	public Stuunimeminfo(Stuunidepinfo stuunidepinfo, Integer sumsid,
			String sumname, Integer sumgrade, String sumposition,
			Set loginpersoninfos, Set breakrulelistinfos) {
		this.stuunidepinfo = stuunidepinfo;
		this.sumsid = sumsid;
		this.sumname = sumname;
		this.sumgrade = sumgrade;
		this.sumposition = sumposition;
		this.loginpersoninfos = loginpersoninfos;
		this.breakrulelistinfos = breakrulelistinfos;
	}

	// Property accessors

	public Integer getSumid() {
		return this.sumid;
	}

	public void setSumid(Integer sumid) {
		this.sumid = sumid;
	}

	public Stuunidepinfo getStuunidepinfo() {
		return this.stuunidepinfo;
	}

	public void setStuunidepinfo(Stuunidepinfo stuunidepinfo) {
		this.stuunidepinfo = stuunidepinfo;
	}

	public Integer getSumsid() {
		return this.sumsid;
	}

	public void setSumsid(Integer sumsid) {
		this.sumsid = sumsid;
	}

	public String getSumname() {
		return this.sumname;
	}

	public void setSumname(String sumname) {
		this.sumname = sumname;
	}

	public Integer getSumgrade() {
		return this.sumgrade;
	}

	public void setSumgrade(Integer sumgrade) {
		this.sumgrade = sumgrade;
	}

	public String getSumposition() {
		return this.sumposition;
	}

	public void setSumposition(String sumposition) {
		this.sumposition = sumposition;
	}

	public Set getLoginpersoninfos() {
		return this.loginpersoninfos;
	}

	public void setLoginpersoninfos(Set loginpersoninfos) {
		this.loginpersoninfos = loginpersoninfos;
	}

	public Set getBreakrulelistinfos() {
		return this.breakrulelistinfos;
	}

	public void setBreakrulelistinfos(Set breakrulelistinfos) {
		this.breakrulelistinfos = breakrulelistinfos;
	}

}