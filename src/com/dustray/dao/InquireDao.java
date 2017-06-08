package com.dustray.dao;

import java.util.List;

import com.dustray.entity.Breakrulelistinfo;

public interface InquireDao {

	/**
	 * 查询所有违纪分页信息（不显示负责人和负责部门）
	 */
	public List<Breakrulelistinfo> getAllDisciplinaryInfo(int pageSize, int pageNum);
	
	/**
	 * 高级查询违纪分页信息（不显示负责人和负责部门）
	 */
	public List<Breakrulelistinfo> getAdvDisciplinaryInfo(int pageSize, int pageNum, String conditionStr);
	
	/**
	 * 根据学号查询登记人代码
	 */
	public String getSumID(String sumSID);
	
	/**
	 * 根据学号查询所在部门代码
	 */
	public String getDepartID(String sumSID);
	
	/**
	 * 根据部门代码查询部门名称
	 */
	public String getDepartName(String departmentID);
	
	/**
	 * 根据单一违纪代码查询信息，用于修改
	 */
	public Breakrulelistinfo getOneDisciplinaryInfo(int brlID);
	
	
}
