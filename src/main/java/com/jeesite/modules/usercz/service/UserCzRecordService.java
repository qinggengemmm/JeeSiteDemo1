/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usercz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.usercz.entity.UserCzRecord;
import com.jeesite.modules.usercz.dao.UserCzRecordDao;

/**
 * 玩家充值记录Service
 * @author mds
 * @version 2019-02-15
 */
@Service
@Transactional(readOnly=true)
public class UserCzRecordService extends CrudService<UserCzRecordDao, UserCzRecord> {

	@Autowired
	public  UserCzRecordDao userCzRecordDao;


	/**
	 * 获取单条数据
	 * @param userCzRecord
	 * @return
	 */
	@Override
	public UserCzRecord get(UserCzRecord userCzRecord) {
		return super.get(userCzRecord);
	}
	
	/**
	 * 查询分页数据
	 * @param userCzRecord 查询条件
	 * @param userCzRecord.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserCzRecord> findPage(UserCzRecord userCzRecord) {
		return super.findPage(userCzRecord);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userCzRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(UserCzRecord userCzRecord) {
		super.save(userCzRecord);
	}
	
	/**
	 * 更新状态
	 * @param userCzRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(UserCzRecord userCzRecord) {
		super.updateStatus(userCzRecord);
	}
	
	/**
	 * 删除数据
	 * @param userCzRecord
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(UserCzRecord userCzRecord) {
		super.delete(userCzRecord);
	}

	public Long getMaxNumber() {
		return userCzRecordDao.getMaxNumber();
	}
}