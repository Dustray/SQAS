package com.dustray.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dustray.dao.HibernateSessionFactory;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Breakrulelistinfo;

public class InquireDaoImpl implements InquireDao {

	/**
	 * 查询所有违纪分页信息（不显示负责人和负责部门）
	 */
	@SuppressWarnings("unchecked")
	public List<Breakrulelistinfo> getAllDisciplinaryInfo(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List<Breakrulelistinfo> list = new ArrayList<Breakrulelistinfo>();
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Breakrulelistinfo order by brlid desc";
		//String hql = "select rule,dep.sudname from Breakrulelistinfo rule inner join Stuunidepinfo dep on rule.brldepartmentid=dep.sudid order by brlid desc";
		//String hql = "select rule,dep.sudname from Breakrulelistinfo rule, Stuunidepinfo dep on rule.brldepartmentid=dep.sudid";
		//String sql = "select rule.*,dep.sudname from Breakrulelistinfo rule inner join Stuunidepinfo dep on rule.brldepartmentid=dep.sudid order by brlid desc";
		Query q = session.createQuery(hql);
		q.setFirstResult((pageNum-1)*pageSize);//过滤前面的pageNum-1页的数据
		q.setMaxResults(pageSize);//取出当前页的数据来
		list = q.list();
		
		session.close();
		
		return list;
	}
	
	/**
	 * 高级查询违纪分页信息（不显示负责人和负责部门）
	 */
	@SuppressWarnings("unchecked")
	public List<Breakrulelistinfo> getAdvDisciplinaryInfo(int pageSize,
			int pageNum, String conditionStr) {
		// TODO Auto-generated method stub
		List<Breakrulelistinfo> list = new ArrayList<Breakrulelistinfo>();
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Breakrulelistinfo where 1=1 "+conditionStr+" order by brlid desc";
		System.out.println(hql);
		Query q = session.createQuery(hql);
		q.setFirstResult((pageNum-1)*pageSize);//过滤前面的pageNum-1页的数据
		q.setMaxResults(pageSize);//取出当前页的数据来
		list = q.list();
		
		session.close();
		
		return list;
	}

	/**
	 * 根据学号查询登记人代码
	 */
	public String getSumID(String sumSID) {
		// TODO Auto-generated method stub
		String sumID = "";
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select sumid from Stuunimeminfo where sumsid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumSID);
		sumID =  q.uniqueResult().toString();
		
		session.close();
		
		return sumID;
	}

	/**
	 * 根据学号查询所在部门代码
	 */
	public String getDepartID(String sumSID) {
		// TODO Auto-generated method stub
		String departmentID = "";
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select stuunidepinfo.sudid from Stuunimeminfo where sumsid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumSID);
		System.out.println("**********"+q.uniqueResult().toString()+"&");
		departmentID = q.uniqueResult().toString();
		
		session.close();
		
		return departmentID;
	}
	
	
	/**
	 * 根据部门代码查询部门名称
	 */
	public String getDepartName(String departmentID) {
		// TODO Auto-generated method stub
		String departmentName = "";
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select sudname from Stuunidepinfo where sudid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, departmentID);
		departmentName = q.uniqueResult().toString();
		
		session.close();
		
		return departmentName;
	}

	/**
	 * 根据单一违纪代码查询信息，用于修改
	 */
	public Breakrulelistinfo getOneDisciplinaryInfo(int brlID) {
		// TODO Auto-generated method stub
		
		Breakrulelistinfo brli = new Breakrulelistinfo();
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Breakrulelistinfo where brlid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, Integer.toString(brlID));
		brli = (Breakrulelistinfo)q.uniqueResult();
		
		session.close();
		
		return brli;
	}

	
	

}
