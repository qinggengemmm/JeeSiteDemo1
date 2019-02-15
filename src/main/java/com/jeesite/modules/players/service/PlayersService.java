/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.players.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.players.entity.Players;
import com.jeesite.modules.players.dao.PlayersDao;

/**
 * playersService
 * @author mds
 * @version 2019-02-13
 */
@Service
@Transactional(readOnly=true)
public class PlayersService extends CrudService<PlayersDao, Players> {
	
	/**
	 * 获取单条数据
	 * @param players
	 * @return
	 */
	@Override
	public Players get(Players players) {
		return super.get(players);
	}
	
	/**
	 * 查询分页数据
	 * @param players 查询条件
	 * @param players.page 分页对象
	 * @return
	 */
	@Override
	public Page<Players> findPage(Players players) {
		return super.findPage(players);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param players
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Players players) {
		super.save(players);
	}
	
	/**
	 * 更新状态
	 * @param players
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Players players) {
		super.updateStatus(players);
	}
	
	/**
	 * 删除数据
	 * @param players
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Players players) {
		super.delete(players);
	}
	
}