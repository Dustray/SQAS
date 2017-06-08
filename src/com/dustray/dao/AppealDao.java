package com.dustray.dao;

import java.util.List;

import com.dustray.entity.Appealinfo;
import com.dustray.entity.Breakrulelistinfo;

public interface AppealDao {

	/**
	 * ��ѯ��֤������Ϣ
	 */
	public boolean verifyAppealInfo(Breakrulelistinfo item, int departmentID);

	/**
	 * ���������Ϣ
	 */
	public void addAppealInfo(Appealinfo item);

	/**
	 * ��ѯ�Ƿ��Ѵ���������Ϣ
	 */
	public boolean checkIfExistAppealInfo(Appealinfo item);

	/**
	 * ��ѯ����������Ϣ
	 */
	public List<Appealinfo> getAllAppealInfo(int pageSize, int pageNum);

	/**
	 * ���ߴ���-�޸Ĵ�����
	 */
	public void disposeTheAppealInfo(int aplID, String str);
}
