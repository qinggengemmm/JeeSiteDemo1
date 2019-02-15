/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usertx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.usertx.entity.UserTxRecord;
import com.jeesite.modules.usertx.dao.UserTxRecordDao;

/**
 * 玩家提现记录Service
 * @author mds
 * @version 2019-02-15
 */
@Service
@Transactional(readOnly=true)
public class UserTxRecordService extends CrudService<UserTxRecordDao, UserTxRecord> {

	@Autowired
	private UserTxRecordDao userTxRecordDao;
	
	/**
	 * 获取单条数据
	 * @param userTxRecord
	 * @return
	 */
	@Override
	public UserTxRecord get(UserTxRecord userTxRecord) {
		return super.get(userTxRecord);
	}

	public Long getMaxNumber(){
		return userTxRecordDao.getMaxNumber();
	}
	
	/**
	 * 查询分页数据
	 * @param userTxRecord 查询条件
	 * @param userTxRecord.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserTxRecord> findPage(UserTxRecord userTxRecord) {
		return super.findPage(userTxRecord);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userTxRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(UserTxRecord userTxRecord) {
		super.save(userTxRecord);
	}
	
	/**
	 * 更新状态
	 * @param userTxRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(UserTxRecord userTxRecord) {
		super.updateStatus(userTxRecord);
	}
	
	/**
	 * 删除数据
	 * @param userTxRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(UserTxRecord userTxRecord) {
		super.delete(userTxRecord);
	}
	
}