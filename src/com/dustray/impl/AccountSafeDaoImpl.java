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
	 * 检查登陆信息是否正确
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
			q.setString(0, studentID); // 获取成员学号
			q.setString(1, memberPassword); // 获取密码
			temp = (Loginpersoninfo) q.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return temp;
	}

	/**
	 * 根据代码查询权限
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
	 * 为成员添加基本信息
	 * 
	 * @param sumi
	 */
	public boolean memInfoRegister(String sumSID, Stuunimeminfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		// 判断是否已存在此学号
		String hql = "select sumid from Stuunimeminfo where sumsid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, sumSID);
		if (q.uniqueResult() != null) {
			return false;
		}

		// Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction(); // 开启事务
		try {
			session.save(item);
			tran.commit(); // 执行事务
		} catch (Exception ex) {
			tran.rollback(); // 回滚事务
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * 为成员添加登陆信息
	 * 
	 * @param item
	 */
	public void memLoginInfoRegister(String sumSID, String mySumID,
			int jurisdiction) {
		// TODO Auto-generated method stub

		// 根据学号获取成员代码
		InquireDao dao = new InquireDaoImpl();
		String sumID = dao.getSumID(sumSID);
		/** 创建外键对象并赋值 **/
		Stuunimeminfo sumi = new Stuunimeminfo();
		sumi.setSumid(Integer.parseInt(sumID));
		// item设置值
		Loginpersoninfo item = new Loginpersoninfo();
		item.setStuunimeminfo(sumi);
		item.setSumpassword(mySumID);// 将注册人代码作为被注册人默认密码（授权码）
		item.setJurisdiction(jurisdiction + 1);
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction(); // 开启事务
		try {
			session.save(item);
			tran.commit(); // 执行事务
		} catch (Exception ex) {
			tran.rollback(); // 回滚事务
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 根据学号和名字查询登记人代码,再用登记人代码和授权码查询，最后更改密码
	 */
	public String checkSumLoginInfo(String sumSID, String sumName,
			String sumGetPass) {
		// TODO Auto-generated method stub
		boolean temp = false;// 这个没用。。。
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
	 * 修改成员登陆密码//首次注册使用授权码修改密码
	 */
	public void changePassword(String loginPerID, String sumPassword) {

		Loginpersoninfo item = new Loginpersoninfo();
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Loginpersoninfo where loginperid = ?";
		Query qs = session.createQuery(hql);
		qs.setString(0, loginPerID);

		item = (Loginpersoninfo) qs.uniqueResult();
		item.setSumpassword(sumPassword);

		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.update(item);
			tran.commit();   //执行事务
		}catch(Exception ex){
			tran.rollback();  //回滚事务
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

}
