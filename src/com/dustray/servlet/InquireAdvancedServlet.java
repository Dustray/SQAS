package com.dustray.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AddDisDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.entity.Stuunimeminfo;
import com.dustray.impl.AddDisDaoImpl;
import com.dustray.impl.InquireDaoImpl;

public class InquireAdvancedServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InquireAdvancedServlet() {
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
		if (request.getParameter("brltype") != "")
			condition += " and brltype like '%"
					+ request.getParameter("brltype") + "%'";
		if (request.getParameter("brlstuname") != "")
			condition += " and brlstuname like '%"
					+ request.getParameter("brlstuname") + "%'";
		if (request.getParameter("brlstugrade") != "")
			condition += " and brlstugrade = "
					+ request.getParameter("brlstugrade");
		if (request.getParameter("brlstuclass") != "")
			condition += " and brlstuclass = '"
					+ request.getParameter("brlstuclass") + "'";
		if (request.getParameter("brldate") != "")
			condition += " and brldate like '%"
					+ request.getParameter("brldate") + "%'";
		if (request.getParameter("brlpoints") != "")
			condition += " and brlpoints = "
					+ request.getParameter("brlpoints");
		if (request.getParameter("brldepartmentid") != "")
			condition += " and brldepartmentid = "
					+ request.getParameter("brldepartmentid");

		// ------------
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
