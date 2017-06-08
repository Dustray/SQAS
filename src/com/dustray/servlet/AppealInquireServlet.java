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
import com.dustray.entity.Appealinfo;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.impl.AppealDaoImpl;
import com.dustray.impl.InquireDaoImpl;
import com.dustray.tools.judgePermission;

public class AppealInquireServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AppealInquireServlet() {
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

		response.setContentType("text/html");

		// ���Ȩ�޿�ʼ,���1��Ȩ�����£���������δ��¼�û��������û�
		judgePermission jp = new judgePermission();
		if (request.getSession().getAttribute("adminNow") != null) {// ����Ƿ��¼
			String studentID = (String) request.getSession().getAttribute(
					"adminNow");

			AppealDao dao = new AppealDaoImpl();
			List<Appealinfo> AppealList = dao.getAllAppealInfo(20, 1);
			request.setAttribute("AppealList", AppealList);

			if (jp.getPermission(studentID, "disposeAppeal") == false) {// ����Ƿ������߹����Ȩ��
				// ��Ȩ�ޣ�ֻ�ܲ鿴
				System.out.println("��Ȩ��");
				request.getRequestDispatcher("appealInquire.jsp").forward(
						request, response);

			} else {
				// ��Ȩ��
				System.out.println("��Ȩ��");
				request.getRequestDispatcher("disposeAppeal.jsp").forward(
						request, response);
			}
		} else {
			response.sendRedirect("error.jsp?info=noLogin");
			return;
		}
		// ���Ȩ�޽���
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
