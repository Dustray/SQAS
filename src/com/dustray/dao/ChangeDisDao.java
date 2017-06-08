package com.dustray.dao;

import com.dustray.entity.Breakrulelistinfo;

public interface ChangeDisDao {
	
	/**
	 * 删除违纪信息
	 * @param item
	 */
	public void deleteDisciplineInfo(Breakrulelistinfo item);
	
	/**
	 * 修改违纪信息
	 */

	public void updateDisciplineInfo(Breakrulelistinfo item);
}
