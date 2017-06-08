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
	 * ��ѯ����Υ�ͷ�ҳ��Ϣ������ʾ�����˺͸����ţ�
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
		q.setFirstResult((pageNum-1)*pageSize);//����ǰ���pageNum-1ҳ������
		q.setMaxResults(pageSize);//ȡ����ǰҳ��������
		list = q.list();
		
		session.close();
		
		return list;
	}
	
	/**
	 * �߼���ѯΥ�ͷ�ҳ��Ϣ������ʾ�����˺͸����ţ�
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
		q.setFirstResult((pageNum-1)*pageSize);//����ǰ���pageNum-1ҳ������
		q.setMaxResults(pageSize);//ȡ����ǰҳ��������
		list = q.list();
		
		session.close();
		
		return list;
	}

	/**
	 * ����ѧ�Ų�ѯ�Ǽ��˴���
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
	 * ����ѧ�Ų�ѯ���ڲ��Ŵ���
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
	 * ���ݲ��Ŵ����ѯ��������
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
	 * ���ݵ�һΥ�ʹ����ѯ��Ϣ�������޸�
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
