package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AppealDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.impl.AppealDaoImpl;
import com.dustray.impl.InquireDaoImpl;
import com.dustray.tools.judgePermission;

public class AlterDisServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AlterDisServlet() {
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

		// 检查权限开始,针对1级权限以下（不含），未登录用户及干事用户
		judgePermission jp = new judgePermission();
		if (request.getSession().getAttribute("adminNow") != null) {// 检查是否登录
			String studentID = (String) request.getSession().getAttribute(
					"adminNow");
			if (jp.getPermission(studentID, "inquireManage") == false) {// 检查是否有权限
				response.sendRedirect("error.jsp?info=nolimit");
				return;
			}
		} else {
			response.sendRedirect("error.jsp?info=noLogin");
			return;
		}
		// 检查权限结束

		// 根据单一违纪代码查询信息，用于修改
		int brlid = Integer.parseInt(request.getParameter("id"));

		InquireDao dao = new InquireDaoImpl();
		Breakrulelistinfo brli = dao.getOneDisciplinaryInfo(brlid);
		request.setAttribute("brli", brli);

		/** 执行申诉处理 **/
		AppealDao daos = new AppealDaoImpl();
		daos.disposeTheAppealInfo(brlid, "已修改");

		request.getRequestDispatcher("alterDiscipline.jsp").forward(request,
				response);

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
