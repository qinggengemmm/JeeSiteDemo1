/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tel.entity.TelGift;
import com.jeesite.modules.tel.dao.TelGiftDao;

/**
 * 话费奖励Service
 * @author mds
 * @version 2019-02-18
 */
@Service
@Transactional(readOnly=true)
public class TelGiftService extends CrudService<TelGiftDao, TelGift> {
	
	/**
	 * 获取单条数据
	 * @param telGift
	 * @return
	 */
	@Override
	public TelGift get(TelGift telGift) {
		return super.get(telGift);
	}
	
	/**
	 * 查询分页数据
	 * @param telGift 查询条件
	 * @param telGift.page 分页对象
	 * @return
	 */
	@Override
	public Page<TelGift> findPage(TelGift telGift) {
		return super.findPage(telGift);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param telGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TelGift telGift) {
		super.save(telGift);
	}
	
	/**
	 * 更新状态
	 * @param telGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TelGift telGift) {
		super.updateStatus(telGift);
	}
	
	/**
	 * 删除数据
	 * @param telGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TelGift telGift) {
		super.delete(telGift);
	}
	
}