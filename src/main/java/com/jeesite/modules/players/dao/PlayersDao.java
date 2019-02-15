/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.players.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.players.entity.Players;

/**
 * playersDAO接口
 * @author mds
 * @version 2019-02-13
 */
@MyBatisDao
public interface PlayersDao extends CrudDao<Players> {
	
}