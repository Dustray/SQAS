package com.dustray.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dustray.dao.ChangeDisDao;
import com.dustray.dao.HibernateSessionFactory;
import com.dustray.entity.Breakrulelistinfo;

public class ChangeDisDaoImpl implements ChangeDisDao {

	/**
	 * 删除违纪信息
	 * @param item
	 */
	public void deleteDisciplineInfo(Breakrulelistinfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.delete(item);
			tran.commit();   //执行事务
		}catch(Exception ex){
			tran.rollback();  //回滚事务
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void updateDisciplineInfo(Breakrulelistinfo item) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
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
