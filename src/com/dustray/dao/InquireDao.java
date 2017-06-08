package com.dustray.dao;

import java.util.List;

import com.dustray.entity.Breakrulelistinfo;

public interface InquireDao {

	/**
	 * ��ѯ����Υ�ͷ�ҳ��Ϣ������ʾ�����˺͸����ţ�
	 */
	public List<Breakrulelistinfo> getAllDisciplinaryInfo(int pageSize, int pageNum);
	
	/**
	 * �߼���ѯΥ�ͷ�ҳ��Ϣ������ʾ�����˺͸����ţ�
	 */
	public List<Breakrulelistinfo> getAdvDisciplinaryInfo(int pageSize, int pageNum, String conditionStr);
	
	/**
	 * ����ѧ�Ų�ѯ�Ǽ��˴���
	 */
	public String getSumID(String sumSID);
	
	/**
	 * ����ѧ�Ų�ѯ���ڲ��Ŵ���
	 */
	public String getDepartID(String sumSID);
	
	/**
	 * ���ݲ��Ŵ����ѯ��������
	 */
	public String getDepartName(String departmentID);
	
	/**
	 * ���ݵ�һΥ�ʹ����ѯ��Ϣ�������޸�
	 */
	public Breakrulelistinfo getOneDisciplinaryInfo(int brlID);
	
	
}
