package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.AddDisDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.entity.Stuunimeminfo;
import com.dustray.impl.AccountSafeDaoImpl;
import com.dustray.impl.AddDisDaoImpl;
import com.dustray.impl.InquireDaoImpl;
import com.dustray.tools.judgePermission;

public class MemberRegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MemberRegServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 检查权限开始,针对1级权限以下（不含），未登录用户
		judgePermission jp = new judgePermission();
		String studentID = "";
		if (request.getSession().getAttribute("adminNow") != null) {
			studentID = (String) request.getSession().getAttribute("adminNow");
			if (jp.getPermission(studentID, "memberManage") == false) {
				response.sendRedirect("error.jsp?info=nolimit");
				return;
			}
		} else {
			response.sendRedirect("error.jsp?info=nolimit");
			return;
		}
		// 检查权限结束
		request.setCharacterEncoding("gbk"); // 转码操作
		/** 从表单中取得值 **/
		String sumSID = request.getParameter("sumsid");
		String sumname = request.getParameter("sumname");
		String sumgrade = request.getParameter("sumgrade");
		String sumdepartmentid = (String) request.getSession().getAttribute(
				"adminDepID");
		String sumposition = request.getParameter("sumposition");

		/** 创建外键对象并赋值 **/
		Stuunidepinfo sud = new Stuunidepinfo();
		sud.setSudid(Integer.parseInt(sumdepartmentid));

		/** 创建对象并且赋值 **/
		Stuunimeminfo sumi = new Stuunimeminfo();

		sumi.setSumsid(Integer.parseInt(sumSID));
		sumi.setSumname(sumname);
		sumi.setSumgrade(Integer.parseInt(sumgrade));
		sumi.setStuunidepinfo(sud);// 外键 管理部门
		sumi.setSumposition(sumposition);

		/** 执行添加基本成员信息操作 **/
		AccountSafeDao dao = new AccountSafeDaoImpl();
		if (!dao.memInfoRegister(sumSID, sumi)) {
			response.sendRedirect("error.jsp?info=existMemInfo");
			return;
		} else {

			InquireDao daos = new InquireDaoImpl();
			String temp = daos.getSumID(studentID);

			String mySumID = (String)request.getSession().getAttribute("adminID");
			AccountSafeDao daoes = new AccountSafeDaoImpl();
			int limitNum = daoes.getLimitNum(temp);
			dao.memLoginInfoRegister(sumSID,mySumID , limitNum);
			response.sendRedirect("memberManage.jsp"); // 页面跳转到添加成员页面中
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
