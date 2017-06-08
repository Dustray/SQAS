package com.dustray.tools;

import com.dustray.dao.AccountSafeDao;
import com.dustray.dao.InquireDao;
import com.dustray.impl.AccountSafeDaoImpl;
import com.dustray.impl.InquireDaoImpl;

public class judgePermission {

	/**
	 * 
	 * @param StudentID
	 * @param requestPage
	 *            index.jsp��ͨ��ҳ��0��1��2��4... indexBackground.jsp��̨��ҳ��0��1��2
	 *            inquire.jsp���߼�����ͨ�����ף���ѯ��ʾҳ�棺0��1��2��4...
	 *            inquireAdvanced.jsp�߼���ѯ����ҳ�棺0��1��2��4...
	 *            inquireManage.jsp��ѯ�������޸�ɾ����ҳ�棺0��1 
	 *            addDiscipline.jsp���ҳ�棺0��1��2
	 * @return
	 */

	// ��ȡȨ�޴���
	public boolean getPermission(String StudentID, String requestPage) {// ѧ�ź��������ҳ��
		boolean limit = false;

		
		
		InquireDao dao = new InquireDaoImpl();
		String temp = dao.getSumID(StudentID);

		AccountSafeDao daos = new AccountSafeDaoImpl();
		int limitNum = daos.getLimitNum(temp);
System.out.println("Ȩ�ޣ�"+limitNum);
		switch (limitNum) {
		case 0:
			limit = zeroLimit(requestPage);
			break;
		case 1:
			limit = oneLimit(requestPage);
			break;
		case 2:
			limit = twoLimit(requestPage);
			break;
		default:
			limit = false;

		}
		return limit;
	}

	/**
	 * 0����������Ա 1���߼�����Ա���������������� 2����ͨ����Ա�����¼��� ����ѡ��3��Ԥ������Ա���೤��֧�鼶����ӵ�����ر��Ȩ��
	 * 4����ͨ�û�����ͨѧ������ӵ�в�ѯ�ĵ͵�Ȩ��
	 */
	// 0��Ȩ�ޣ�ȫ��Ȩ��
	public boolean zeroLimit(String rp) {

		return true;
	}

	// 1��Ȩ�ޣ��������������ϣ�ȫ��Ȩ�ޣ���ӣ�ɾ��
	public boolean oneLimit(String rp) {
		if(rp == "disposeAppeal") {//���ߴ���
			return true;
		}
		if(rp == "memberManage") {//���ߴ���
			return true;
		}
		
		return true;
	}

	// 2��Ȩ�ޣ����£���ӣ���ѯȨ��
	public boolean twoLimit(String rp) {

		if (rp == "addDiscipline") {//���
			return true;
		}
		if (rp == "inquireManage") {//�޸�ɾ��
			return false;
		}
		if (rp == "appealInquire") {//���߲�ѯ
			return true;
		}
		if(rp == "disposeAppeal") {//���ߴ���
			return false;
		}
		return false;
	}
}
