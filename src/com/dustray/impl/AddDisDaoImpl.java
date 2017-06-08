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
		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.save(item);
			tran.commit();   //执行事务
		}catch(Exception ex){
			tran.rollback();  //回滚事务
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

}
