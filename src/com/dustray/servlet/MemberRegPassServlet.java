package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.entity.Stuunimeminfo;
import com.dustray.impl.AccountSafeDaoImpl;
import com.dustray.impl.InquireDaoImpl;
import com.dustray.tools.judgePermission;

public class MemberRegPassServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MemberRegPassServlet() {
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

		request.setCharacterEncoding("gbk"); // 转码操作
		/** 从表单中取得值 **/
		String sumSID = request.getParameter("sumsid");
		System.out.println("a");
		String sumName = request.getParameter("sumname");
		System.out.println("b");
		String sumGetPass = request.getParameter("sumgetpass");
		System.out.println("c");
		String sumPassword = request.getParameter("sumpassword");
		System.out.println("d");
		AccountSafeDao dao = new AccountSafeDaoImpl();
		if (dao.checkSumLoginInfo(sumSID, sumName, sumGetPass) != "") {
			dao.changePassword(dao.checkSumLoginInfo(sumSID, sumName,
					sumGetPass), sumPassword);
			response.sendRedirect("login.jsp"); // 页面跳转到添加成员页面中
		} else {
			response.sendRedirect("error.jsp"); // 页面跳转到添加成员页面中
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
