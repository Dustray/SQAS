package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.InquireDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.impl.InquireDaoImpl;

public class InquireSimpleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InquireSimpleServlet() {
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

		request.setCharacterEncoding("gbk"); // ×ªÂë²Ù×÷
		
		String condition = " ";
		
		if(request.getParameter("selectContentA").indexOf("'")!=-1){//ÅÐ¶ÏËÑË÷×Ö·û´®ÊÇ·ñ´æÔÚ¡°'¡±×Ö·û£¬Èç¹û´æÔÚÔò·µ»Ø¡£
			return;
		}
		
		
		if (request.getParameter("selectContentA") == "") {
			condition = " ";
			if (request.getParameter("selectType").equals("brldepartmentid")) {
				condition += " and brldepartmentid = "
						+ request.getParameter("selectDepartmentB");
			}
		} else {
			if (request.getParameter("selectType").equals("brlstuname")) {
				condition += " and brlstuname like '%"
						+ request.getParameter("selectContentA") + "%'";
			} else if (request.getParameter("selectType").equals("brlstuclass")) {
				condition += " and brlstuclass like '%"
						+ request.getParameter("selectContentA") + "%'";
			} else if (request.getParameter("selectType").equals("brldepartmentid")) {
				condition += " and brldepartmentid = "
						+ request.getParameter("selectDepartmentB");
			} else if (request.getParameter("selectType").equals("brldate")) {
				condition += " and brldate like '%"
						+ request.getParameter("selectContentA") + "%'";
			}

		}
		System.out.println(condition);
		InquireDao dao = new InquireDaoImpl();
		List<Breakrulelistinfo> disciplineList = dao.getAdvDisciplinaryInfo(20,
				1, condition);
		// for(Breakrulelistinfo br:disciplineList){
		// System.out.println("bt:"+br.getBrlstuname());
		// }
		// System.out.println("List:"+disciplineList);
		request.setAttribute("DisciplineList", disciplineList);
		request.getRequestDispatcher("inquire.jsp").forward(request, response);
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
