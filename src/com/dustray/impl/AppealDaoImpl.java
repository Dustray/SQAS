package com.dustray.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dustray.dao.AppealDao;
import com.dustray.dao.HibernateSessionFactory;
import com.dustray.entity.Appealinfo;
import com.dustray.entity.Breakrulelistinfo;
import com.dustray.entity.Stuunidepinfo;

public class AppealDaoImpl implements AppealDao {

	/**
	 * 查询验证申诉信息
	 */
	public boolean verifyAppealInfo(Breakrulelistinfo item, int departmentID) {
		// TODO Auto-generated method stub

		boolean temp = false;
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Breakrulelistinfo where brlstuname = ? and brlstugrade = ? and brlstuclass = ? and brlid = ? and brldepartmentid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, item.getBrlstuname());
		q.setInteger(1, item.getBrlstugrade());
		q.setString(2, item.getBrlstuclass());
		q.setInteger(3, item.getBrlid());
		q.setInteger(4, departmentID);

		System.out.println(item.getBrlstuname() + item.getBrlstugrade()
				+ item.getBrlstuclass() + item.getBrlid() + departmentID);
		Breakrulelistinfo brli = new Breakrulelistinfo();
		brli = (Breakrulelistinfo) q.uniqueResult();
		if (brli != null) {// ???怎样判断是否为空
			temp = true;
			System.out.println("验证成功！！！");
		} else {
			temp = false;
			System.out.println("验证失败！！！");

		}

		session.close();
		return temp;
	}

	/**
	 * 添加申请信息
	 */
	public void addAppealInfo(Appealinfo item) {
		// TODO Auto-generated method stub
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
	 * 查询是否已存在申诉信息
	 */
	public boolean checkIfExistAppealInfo(Appealinfo item) {
		// TODO Auto-generated method stub
		boolean temp = false;
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Appealinfo where Aplname = ? and Aplbrlid = ? and Aplgradeclass = ? and Apldepartment = ?";
		Query q = session.createQuery(hql);
		q.setString(0, item.getAplname());
		q.setInteger(1, item.getAplbrlid());
		q.setString(2, item.getAplgradeclass());
		q.setString(3, item.getApldepartment());

		System.out.println(item.getAplname() + item.getAplbrlid()
				+ item.getAplgradeclass() + item.getApldepartment());
		Appealinfo ai = new Appealinfo();
		ai = (Appealinfo) q.uniqueResult();
		if (ai != null) {
			temp = true;
			System.out.println("已经存在此申诉");
		} else {
			temp = false;
			System.out.println("不存在此申诉");

		}

		session.close();
		return temp;
	}

	/**
	 * 查询所有申诉信息
	 */
	public List<Appealinfo> getAllAppealInfo(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List<Appealinfo> list = new ArrayList<Appealinfo>();
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Appealinfo where aplresult like '%待审%' or aplresult like '%处理中%' order by aplid asc";

		Query q = session.createQuery(hql);
		q.setFirstResult((pageNum - 1) * pageSize);// 过滤前面的pageNum-1页的数据
		q.setMaxResults(pageSize);// 取出当前页的数据来
		list = q.list();

		session.close();

		return list;
	}

	/**
	 * 处理一条申诉信息
	 */
	public void disposeTheAppealInfo(int aplID, String str) {
		// TODO Auto-generated method stub
		Appealinfo ai = new Appealinfo();
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Appealinfo where aplbrlid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, Integer.toString(aplID));
		try {
			if (q.uniqueResult() != null) {//判断有无申诉信息
				ai = (Appealinfo) q.uniqueResult();
			} else {
				return;
			}
		} catch (Exception e) {
			System.out.println(e + "系统中存在两条相同id信息，请联系管理员");
		}

		ai.setAplresult(str);

		Session sessions = HibernateSessionFactory.getSession();
		Transaction tran = sessions.beginTransaction(); // 开启事务
		try {
			sessions.update(ai);
			tran.commit(); // 执行事务
		} catch (Exception ex) {
			tran.rollback(); // 回滚事务
			ex.printStackTrace();
		} finally {
			sessions.close();
		}
	}

}
