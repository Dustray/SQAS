package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AppealDao;
import com.dustray.dao.ChangeDisDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.impl.AppealDaoImpl;
import com.dustray.impl.ChangeDisDaoImpl;
import com.dustray.tools.judgePermission;

public class DeleteDisServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteDisServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 检查权限开始,针对1级权限以下（不含），未登录用户及干事用户
		judgePermission jp = new judgePermission();
		if (request.getSession().getAttribute("adminNow") != null) {//检查是否登录
			String studentID = (String) request.getSession().getAttribute(
					"adminNow");
			if (jp.getPermission(studentID, "inquireManage") == false) {//检查是否有权限
				response.sendRedirect("error.jsp?info=nolimit");
				return;
			}
		} else {
			response.sendRedirect("error.jsp?info=noLogin");
			return;
		}
		// 检查权限结束
		
		request.setCharacterEncoding("gbk"); // 转码操作
		
		/** 从表单中取得值 **/
		int brlid = Integer.parseInt(request.getParameter("id"));
		
		/** 创建对象并且赋值 **/
		Breakrulelistinfo brli = new Breakrulelistinfo();
		
		brli.setBrlid(brlid);
		
		
		

		/** 执行删除操作 **/
		ChangeDisDao dao = new ChangeDisDaoImpl();
		dao.deleteDisciplineInfo(brli);
		
		/** 执行申诉处理 **/
		
		AppealDao daos = new AppealDaoImpl();
		daos.disposeTheAppealInfo(brlid, "已删除");
		
	
		response.sendRedirect("InquireServlet?limit=1"); // 页面跳转到查询页面中，权限1，回到信息管理页面
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
