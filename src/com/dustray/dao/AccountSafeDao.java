package com.dustray.dao;

import com.dustray.entity.Loginpersoninfo;
import com.dustray.entity.Stuunimeminfo;

public interface AccountSafeDao {

	/**
	 * ����½��Ϣ�Ƿ���ȷ
	 * @return
	 */
	public Loginpersoninfo getCheckLoginInfo(String studentID, String memberPassword);
	
	/**
	 * ���ݴ����ѯȨ��
	 */
	public int getLimitNum(String temp);
	
	/**
	 * Ϊ��Ա��ӻ�����Ϣ
	 * @param sumi
	 */
	public boolean memInfoRegister(String sumSID, Stuunimeminfo item);
	
	/**
	 * Ϊ��Ա��ӵ�½��Ϣ
	 * @param item
	 */
	public void memLoginInfoRegister(String sumSID, String mySumID, int jurisdiction);
	
	/**
	 * ����ѧ�ź����ֲ�ѯ�Ǽ��˴���,���õǼ��˴������Ȩ���ѯ������������
	 */
	public String checkSumLoginInfo(String sumSID,String sumName,String sumGetPass);
	
	/**
	 * �޸ĳ�Ա��½����//�״�ע��ʹ����Ȩ���޸�����
	 */
	public void changePassword(String loginPerID,String sumPassword);
	
}
