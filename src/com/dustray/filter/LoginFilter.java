package com.dustray.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest myReq = (HttpServletRequest) request;
		HttpSession session = myReq.getSession();
		//String StudentID = (String) session.getAttribute("adminNow");
		String StudentID1 = (String) ((HttpServletRequest) request).getSession().getAttribute("adminNow");
		String reqUrl = myReq.getRequestURI();
		// �û�û�е�¼���Ҳ��ǵ�¼ҳ�棬Ҳ���ǵ�¼����ҳ��
		// ��һ��һ��Ҫ�У�����ͻ��Ϊ��ѭ�������³����޷�����
		if (StudentID1 == null && !reqUrl.equals("/SUQAS/login.jsp")) {
			HttpServletResponse myRes = (HttpServletResponse) response;
			myRes.sendRedirect(myReq.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
