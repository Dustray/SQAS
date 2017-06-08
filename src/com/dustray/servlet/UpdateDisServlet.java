package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AddDisDao;
import com.dustray.dao.ChangeDisDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.entity.Stuunimeminfo;
import com.dustray.impl.AddDisDaoImpl;
import com.dustray.impl.ChangeDisDaoImpl;
import com.dustray.tools.judgePermission;

public class UpdateDisServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateDisServlet() {
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

		System.out.println("ssss");
		// 检查权限开始,针对2级权限以下（不含），未登录用户
		judgePermission jp = new judgePermission();
		if (request.getSession().getAttribute("adminNow") != null) {
			String studentID = (String) request.getSession().getAttribute(
					"adminNow");
			if (jp.getPermission(studentID, "addDiscipline") == false) {
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
		String brlid=request.getParameter("brlid");
		String brltype = request.getParameter("brltype");
		String brlstuname = request.getParameter("brlstuname");
		String brlstugrade = request.getParameter("brlstugrade");
		String brlstuclass = request.getParameter("brlstuclass");
		String brldate = request.getParameter("brldate");
		String brldetail = request.getParameter("brldetail");
		String brlpoints = request.getParameter("brlpoints");
		String brlpointsunit = request.getParameter("brlpointsunit");
		String brldealadminid = request.getParameter("brldealadminid");
		String brldepartmentid = (String) request.getSession().getAttribute(
				"adminDepID");// request.getParameter("brldepartmentid");

		String[] arr = brlstuname.split(";|；");// 一次添加多个名字

		/** 创建外键对象并赋值 **/
		Stuunimeminfo sum = new Stuunimeminfo();
		sum.setSumid(Integer.parseInt(brldealadminid));

		Stuunidepinfo sud = new Stuunidepinfo();
		sud.setSudid(Integer.parseInt(brldepartmentid));

		/** 创建对象并且赋值 **/
		Breakrulelistinfo brli = new Breakrulelistinfo();
		brli.setBrlid(Integer.parseInt(brlid));
		brli.setBrltype(brltype);
		// brli.setBrlstuname(arr[i]);
		brli.setBrlstugrade(Integer.parseInt(brlstugrade));
		brli.setBrlstuclass(brlstuclass);
		brli.setBrldate(Timestamp.valueOf(brldate));
		brli.setBrldetail(brldetail);
		brli.setBrlpoints(Double.parseDouble(brlpoints));
		brli.setBrlpointsunit(brlpointsunit);
		brli.setStuunimeminfo(sum);// 外键 管理人员
		brli.setStuunidepinfo(sud);// 外键 管理部门
		brli.setBrldealdate(new Timestamp(System.currentTimeMillis()));// 获取当前时间

		for (int i = 0; i < arr.length; i++) {// 循环添加

			brli.setBrlstuname(arr[i]);
			/** 执行添加操作 **/
			ChangeDisDao dao = new ChangeDisDaoImpl();
			dao.updateDisciplineInfo(brli);
		}
		response.sendRedirect("InquireServlet?limit=1"); // 页面跳转到查询页面中
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
