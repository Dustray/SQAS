package com.dustray.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.HibernateSessionFactory;
import com.dustray.dao.InquireDao;
import com.dustray.entity.Loginpersoninfo;
import com.dustray.entity.Stuunidepinfo;
import com.dustray.entity.Stuunimeminfo;

public class AccountSafeDaoImpl implements AccountSafeDao {

	/**
	 * ����½��Ϣ�Ƿ���ȷ
	 * 
	 * @return
	 */
	public Loginpersoninfo getCheckLoginInfo(String studentID,
			String memberPassword) {
		// TODO Auto-generated method stub

		Loginpersoninfo temp = null;
		Session session = HibernateSessionFactory.getSession();

		try {
			String hql = "from Loginpersoninfo where sumid = (select sumid from Stuunimeminfo where sumsid = ?) and sumpassword = ?";
			// String hql =
			// "from Loginpersoninfo where loginperid = ? and sumpassword = '?'";
			Query q = session.createQuery(hql);
			// System.out.println("id"+studentID+" password:"+memberPassword);
			q.setString(0, studentID); // ��ȡ��Աѧ��
			q.setString(1, memberPassword); // ��ȡ����
			temp = (Loginpersoninfo) q.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return temp;
	}

	/**
	 * ���ݴ����ѯȨ��
	 */
	public int getLimitNum(String sumID) {
		// TODO Auto-generated method stub
		int limitNum = 0;

		Session session = HibernateSessionFactory.getSession();

		String hql = "select jurisdiction from Loginpersoninfo where sumid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumID);
		limitNum = Integer.parseInt(q.uniqueResult().toString());

		session.close();

		return limitNum;
	}

	/**
	 * Ϊ��Ա��ӻ�����Ϣ
	 * 
	 * @param sumi
	 */
	public boolean memInfoRegister(String sumSID, Stuunimeminfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		// �ж��Ƿ��Ѵ��ڴ�ѧ��
		String hql = "select sumid from Stuunimeminfo where sumsid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumSID);
		if (q.uniqueResult() != null) {
			return false;
		}

		// Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction(); // ��������
		try {
			session.save(item);
			tran.commit(); // ִ������
		} catch (Exception ex) {
			tran.rollback(); // �ع�����
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * Ϊ��Ա��ӵ�½��Ϣ
	 * 
	 * @param item
	 */
	public void memLoginInfoRegister(String sumSID, String mySumID,
			int jurisdiction) {
		// TODO Auto-generated method stub

		// ����ѧ�Ż�ȡ��Ա����
		InquireDao dao = new InquireDaoImpl();
		String sumID = dao.getSumID(sumSID);
		/** ����������󲢸�ֵ **/
		Stuunimeminfo sumi = new Stuunimeminfo();
		sumi.setSumid(Integer.parseInt(sumID));
		// item����ֵ
		Loginpersoninfo item = new Loginpersoninfo();
		item.setStuunimeminfo(sumi);
		item.setSumpassword(mySumID);// ��ע���˴�����Ϊ��ע����Ĭ�����루��Ȩ�룩
		item.setJurisdiction(jurisdiction + 1);
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction(); // ��������
		try {
			session.save(item);
			tran.commit(); // ִ������
		} catch (Exception ex) {
			tran.rollback(); // �ع�����
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * ����ѧ�ź����ֲ�ѯ�Ǽ��˴���,���õǼ��˴������Ȩ���ѯ������������
	 */
	public String checkSumLoginInfo(String sumSID, String sumName,
			String sumGetPass) {
		// TODO Auto-generated method stub
		boolean temp = false;// ���û�á�����
		String loginPerID = "";
		String sumID = "";
		Session session = HibernateSessionFactory.getSession();

		String hql = "select sumid from Stuunimeminfo where sumsid = ? and sumname = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumSID);
		q.setString(1, sumName);
		if (q.uniqueResult() != null) {
			sumID = q.uniqueResult().toString();

			String hqls = "select loginperid from Loginpersoninfo where sumid = ? and sumpassword = ?";
			Query qs = session.createQuery(hqls);
			qs.setString(0, sumID);
			qs.setString(1, sumGetPass);
			if (qs.uniqueResult() != null) {
				loginPerID = qs.uniqueResult().toString();
				temp = true;
			} else {
				temp = false;
			}
		} else {
			temp = false;
		}

		session.close();

		return loginPerID;
	}

	/**
	 * �޸ĳ�Ա��½����//�״�ע��ʹ����Ȩ���޸�����
	 */
	public void changePassword(String loginPerID, String sumPassword) {

		Loginpersoninfo item = new Loginpersoninfo();
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Loginpersoninfo where loginperid = ?";
		Query qs = session.createQuery(hql);
		qs.setString(0, loginPerID);

		item = (Loginpersoninfo) qs.uniqueResult();
		item.setSumpassword(sumPassword);

		Transaction tran = session.beginTransaction();  //��������
		try{
			session.update(item);
			tran.commit();   //ִ������
		}catch(Exception ex){
			tran.rollback();  //�ع�����
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

}
