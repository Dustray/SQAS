package com.dustray.dao;

import com.dustray.entity.Loginpersoninfo;
import com.dustray.entity.Stuunimeminfo;

public interface AccountSafeDao {

	/**
	 * 检查登陆信息是否正确
	 * @return
	 */
	public Loginpersoninfo getCheckLoginInfo(String studentID, String memberPassword);
	
	/**
	 * 根据代码查询权限
	 */
	public int getLimitNum(String temp);
	
	/**
	 * 为成员添加基本信息
	 * @param sumi
	 */
	public boolean memInfoRegister(String sumSID, Stuunimeminfo item);
	
	/**
	 * 为成员添加登陆信息
	 * @param item
	 */
	public void memLoginInfoRegister(String sumSID, String mySumID, int jurisdiction);
	
	/**
	 * 根据学号和名字查询登记人代码,再用登记人代码和授权码查询，最后更改密码
	 */
	public String checkSumLoginInfo(String sumSID,String sumName,String sumGetPass);
	
	/**
	 * 修改成员登陆密码//首次注册使用授权码修改密码
	 */
	public void changePassword(String loginPerID,String sumPassword);
	
}
