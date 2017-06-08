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

		// ���Ȩ�޿�ʼ,���1��Ȩ�����£���������δ��¼�û�
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
		// ���Ȩ�޽���
		request.setCharacterEncoding("gbk"); // ת�����
		/** �ӱ���ȡ��ֵ **/
		String sumSID = request.getParameter("sumsid");
		String sumname = request.getParameter("sumname");
		String sumgrade = request.getParameter("sumgrade");
		String sumdepartmentid = (String) request.getSession().getAttribute(
				"adminDepID");
		String sumposition = request.getParameter("sumposition");

		/** ����������󲢸�ֵ **/
		Stuunidepinfo sud = new Stuunidepinfo();
		sud.setSudid(Integer.parseInt(sumdepartmentid));

		/** ���������Ҹ�ֵ **/
		Stuunimeminfo sumi = new Stuunimeminfo();

		sumi.setSumsid(Integer.parseInt(sumSID));
		sumi.setSumname(sumname);
		sumi.setSumgrade(Integer.parseInt(sumgrade));
		sumi.setStuunidepinfo(sud);// ��� ������
		sumi.setSumposition(sumposition);

		/** ִ����ӻ�����Ա��Ϣ���� **/
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
			response.sendRedirect("memberManage.jsp"); // ҳ����ת����ӳ�Աҳ����
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
