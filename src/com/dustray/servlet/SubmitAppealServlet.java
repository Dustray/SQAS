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
import com.dustray.dao.AppealDao;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Appealinfo;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.impl.AddDisDaoImpl;
import com.dustray.impl.AppealDaoImpl;
import com.dustray.impl.InquireDaoImpl;

public class SubmitAppealServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SubmitAppealServlet() {
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

		response.setContentType("text/html");
		
		request.setCharacterEncoding("gbk"); // ת�����
		
		//��һ�����ж��ύ����Ϣ�Ƿ������Υ�ͱ���
		/** �ӱ���ȡ��ֵ **/
		String brlid=request.getParameter("brlid");
		String brlstuname = request.getParameter("brlstuname");
		String brlstugrade = request.getParameter("brlstugrade");
		String brlstuclass = request.getParameter("brlstuclass");
		
		String brldepartmentid = request.getParameter("brldepartmentid");
		
		
		/** ���������Ҹ�ֵ **/
		Breakrulelistinfo brli = new Breakrulelistinfo();
		brli.setBrlid(Integer.parseInt(brlid));
		brli.setBrlstuname(brlstuname);
		brli.setBrlstugrade(Integer.parseInt(brlstugrade));
		brli.setBrlstuclass(brlstuclass);
		
		
		AppealDao dao = new AppealDaoImpl();
		//System.out.println(""+Integer.parseInt(brldepartmentid));
		if(dao.verifyAppealInfo(brli,Integer.parseInt(brldepartmentid))){
			
			
			String aplreason = request.getParameter("aplreason");
			Appealinfo ai = new Appealinfo();
			
			ai.setAplname(brlstuname);
			ai.setAplbrlid(Integer.parseInt(brlid));
			ai.setAplgradeclass(brlstugrade+"��"+brlstuclass);
			ai.setApldepartment(brldepartmentid);
			ai.setAplreason(aplreason);
			ai.setApldate(new Timestamp(System.currentTimeMillis()));
			ai.setAplresult("������");
			
			//�ڶ�������ѯ�ж��Ƿ������������
			if(!dao.checkIfExistAppealInfo(ai)){//������
			
				//���������ύ������Ϣ
				dao.addAppealInfo(ai);
				response.sendRedirect("appeal.jsp?info=���ύ");
			}else{
				response.sendRedirect("error.jsp?info=ExistAppealFailed");
			}
			
		}else{
			response.sendRedirect("error.jsp?info=verifyFailed");
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
