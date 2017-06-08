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

public class InquireServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InquireServlet() {
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

		int InquireLimit = Integer.parseInt(request.getParameter("limit"));
		/** ��ҳ��ʼ **/
		int nowPage=0;
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
			if (nowPage < 1) {
				nowPage = 1;
			}
		}
		else{
			nowPage = 1;
		}
		/** ��ҳ���� **/
		InquireDao dao = new InquireDaoImpl();
		List<Breakrulelistinfo> disciplineList = dao.getAllDisciplinaryInfo(20,
				nowPage);
		// for(Breakrulelistinfo br:disciplineList){
		// System.out.println("bt:"+br.getBrlstuname());
		// }
		// System.out.println("List:"+disciplineList);
		request.setAttribute("DisciplineList", disciplineList);
		if (InquireLimit == 1) {// Ȩ��1��������Ϣ����ҳ��
			request.getRequestDispatcher("inquireManage.jsp?nowPage="+nowPage).forward(request,
					response);
		} else if (InquireLimit == 2) {// Ȩ��2��������ͨ��ѯҳ��
			request.getRequestDispatcher("inquire.jsp?nowPage="+nowPage).forward(request,
					response);
		} else if (InquireLimit == 4) {// Ȩ��4��������ͨ��ѯҳ��
			request.getRequestDispatcher("inquire.jsp?nowPage="+nowPage).forward(
					request, response);
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
