package com.dustray.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dustray.dao.AddDisDao;
import com.dustray.dao.HibernateSessionFactory;
import com.dustray.entity.Breakrulelistinfo;

public class AddDisDaoImpl implements AddDisDao {

	public void addDisciplineInfo(Breakrulelistinfo item) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������
		try{
			session.save(item);
			tran.commit();   //ִ������
		}catch(Exception ex){
			tran.rollback();  //�ع�����
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

}
