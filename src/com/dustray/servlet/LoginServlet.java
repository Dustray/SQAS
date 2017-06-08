package com.dustray.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Loginpersoninfo;
import com.dustray.impl.AccountSafeDaoImpl;
import com.dustray.impl.InquireDaoImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		doPost(request,response);
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

		response.setContentType("text/html");
		
		String studentID = request.getParameter("sumSID");//学号
		String memberPassword = request.getParameter("sumPassword");
		
		if(studentID.equals("")||memberPassword.equals("")){
			response.sendRedirect("login.jsp");
		}else{
			AccountSafeDao dao = new AccountSafeDaoImpl();
			
			Loginpersoninfo lpi = dao.getCheckLoginInfo(studentID, memberPassword);
			if(lpi == null){
				response.sendRedirect("login.jsp");
			}else{
				
				
				request.getSession().setAttribute("adminNow", studentID);
				
				
				/**
				 * session方式设置登陆人部门代码和名称
				 */
				InquireDao idao = new InquireDaoImpl();
				
				String depID = idao.getDepartID(studentID);

				String depName = idao.getDepartName(depID);
				/**
				 * session方式设置登陆人代码
				 */
				String sumID = idao.getSumID(studentID);
				
				request.getSession().setAttribute("adminDepName", depName);
				request.getSession().setAttribute("adminDepID", depID);
				request.getSession().setAttribute("adminID", sumID);
				/*结束*/
				response.sendRedirect("indexBackground.jsp");
			}
			
		}
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
