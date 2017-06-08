package com.dustray.dao;

import java.util.List;

import com.dustray.entity.Appealinfo;
import com.dustray.entity.Breakrulelistinfo;

public interface AppealDao {

	/**
	 * 查询验证申请信息
	 */
	public boolean verifyAppealInfo(Breakrulelistinfo item, int departmentID);

	/**
	 * 添加申请信息
	 */
	public void addAppealInfo(Appealinfo item);

	/**
	 * 查询是否已存在申请信息
	 */
	public boolean checkIfExistAppealInfo(Appealinfo item);

	/**
	 * 查询所有申请信息
	 */
	public List<Appealinfo> getAllAppealInfo(int pageSize, int pageNum);

	/**
	 * 申诉处理-修改处理结果
	 */
	public void disposeTheAppealInfo(int aplID, String str);
}
