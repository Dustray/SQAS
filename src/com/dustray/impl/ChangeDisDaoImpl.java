package com.dustray.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dustray.dao.ChangeDisDao;
import com.dustray.dao.HibernateSessionFactory;
import com.dustray.entity.Breakrulelistinfo;

public class ChangeDisDaoImpl implements ChangeDisDao {

	/**
	 * ɾ��Υ����Ϣ
	 * @param item
	 */
	public void deleteDisciplineInfo(Breakrulelistinfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������
		try{
			session.delete(item);
			tran.commit();   //ִ������
		}catch(Exception ex){
			tran.rollback();  //�ع�����
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void updateDisciplineInfo(Breakrulelistinfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
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
