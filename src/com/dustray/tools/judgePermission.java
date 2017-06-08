package com.dustray.tools;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.InquireDao;
import com.dustray.impl.AccountSafeDaoImpl;
import com.dustray.impl.InquireDaoImpl;

public class judgePermission {

	/**
	 * 
	 * @param StudentID
	 * @param requestPage
	 *            index.jsp普通主页：0、1、2、4... indexBackground.jsp后台主页：0、1、2
	 *            inquire.jsp（高级、普通、简易）查询显示页面：0、1、2、4...
	 *            inquireAdvanced.jsp高级查询请求页面：0、1、2、4...
	 *            inquireManage.jsp查询、管理（修改删除）页面：0、1 
	 *            addDiscipline.jsp添加页面：0、1、2
	 * @return
	 */

	// 获取权限代码
	public boolean getPermission(String StudentID, String requestPage) {// 学号和请求访问页面
		boolean limit = false;

		
		
		InquireDao dao = new InquireDaoImpl();
		String temp = dao.getSumID(StudentID);

		AccountSafeDao daos = new AccountSafeDaoImpl();
		int limitNum = daos.getLimitNum(temp);
System.out.println("权限："+limitNum);
		switch (limitNum) {
		case 0:
			limit = zeroLimit(requestPage);
			break;
		case 1:
			limit = oneLimit(requestPage);
			break;
		case 2:
			limit = twoLimit(requestPage);
			break;
		default:
			limit = false;

		}
		return limit;
	}

	/**
	 * 0：超级管理员 1：高级管理员（部长副部长级） 2：普通管理员（干事级） （备选）3：预备管理员（班长团支书级）：拥有下载表格权限
	 * 4：普通用户（普通学生）：拥有查询的低等权限
	 */
	// 0号权限：全部权限
	public boolean zeroLimit(String rp) {

		return true;
	}

	// 1号权限：部长副部长以上：全部权限：添加，删除
	public boolean oneLimit(String rp) {
		if(rp == "disposeAppeal") {//申诉处理
			return true;
		}
		if(rp == "memberManage") {//申诉处理
			return true;
		}
		
		return true;
	}

	// 2号权限：干事：添加，查询权限
	public boolean twoLimit(String rp) {

		if (rp == "addDiscipline") {//添加
			return true;
		}
		if (rp == "inquireManage") {//修改删除
			return false;
		}
		if (rp == "appealInquire") {//申诉查询
			return true;
		}
		if(rp == "disposeAppeal") {//申诉处理
			return false;
		}
		return false;
	}
}
