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
	 * ��ѯ��֤������Ϣ
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
		if (brli != null) {// ???�����ж��Ƿ�Ϊ��
			temp = true;
			System.out.println("��֤�ɹ�������");
		} else {
			temp = false;
			System.out.println("��֤ʧ�ܣ�����");

		}

		session.close();
		return temp;
	}

	/**
	 * ���������Ϣ
	 */
	public void addAppealInfo(Appealinfo item) {
		// TODO Auto-generated method stub
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
	 * ��ѯ�Ƿ��Ѵ���������Ϣ
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
			System.out.println("�Ѿ����ڴ�����");
		} else {
			temp = false;
			System.out.println("�����ڴ�����");

		}

		session.close();
		return temp;
	}

	/**
	 * ��ѯ����������Ϣ
	 */
	public List<Appealinfo> getAllAppealInfo(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List<Appealinfo> list = new ArrayList<Appealinfo>();
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Appealinfo where aplresult like '%����%' or aplresult like '%������%' order by aplid asc";

		Query q = session.createQuery(hql);
		q.setFirstResult((pageNum - 1) * pageSize);// ����ǰ���pageNum-1ҳ������
		q.setMaxResults(pageSize);// ȡ����ǰҳ��������
		list = q.list();

		session.close();

		return list;
	}

	/**
	 * ����һ��������Ϣ
	 */
	public void disposeTheAppealInfo(int aplID, String str) {
		// TODO Auto-generated method stub
		Appealinfo ai = new Appealinfo();
		Session session = HibernateSessionFactory.getSession();

		String hql = "from Appealinfo where aplbrlid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, Integer.toString(aplID));
		try {
			if (q.uniqueResult() != null) {//�ж�����������Ϣ
				ai = (Appealinfo) q.uniqueResult();
			} else {
				return;
			}
		} catch (Exception e) {
			System.out.println(e + "ϵͳ�д���������ͬid��Ϣ������ϵ����Ա");
		}

		ai.setAplresult(str);

		Session sessions = HibernateSessionFactory.getSession();
		Transaction tran = sessions.beginTransaction(); // ��������
		try {
			sessions.update(ai);
			tran.commit(); // ִ������
		} catch (Exception ex) {
			tran.rollback(); // �ع�����
			ex.printStackTrace();
		} finally {
			sessions.close();
		}
	}

}
