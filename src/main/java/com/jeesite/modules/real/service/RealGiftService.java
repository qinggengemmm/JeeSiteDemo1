/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.real.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.real.entity.RealGift;
import com.jeesite.modules.real.dao.RealGiftDao;

/**
 * 实物奖励Service
 * @author mds
 * @version 2019-02-18
 */
@Service
@Transactional(readOnly=true)
public class RealGiftService extends CrudService<RealGiftDao, RealGift> {
	
	/**
	 * 获取单条数据
	 * @param realGift
	 * @return
	 */
	@Override
	public RealGift get(RealGift realGift) {
		return super.get(realGift);
	}
	
	/**
	 * 查询分页数据
	 * @param realGift 查询条件
	 * @param realGift.page 分页对象
	 * @return
	 */
	@Override
	public Page<RealGift> findPage(RealGift realGift) {
		return super.findPage(realGift);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param realGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(RealGift realGift) {
		super.save(realGift);
	}
	
	/**
	 * 更新状态
	 * @param realGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(RealGift realGift) {
		super.updateStatus(realGift);
	}
	
	/**
	 * 删除数据
	 * @param realGift
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(RealGift realGift) {
		super.delete(realGift);
	}
	
}