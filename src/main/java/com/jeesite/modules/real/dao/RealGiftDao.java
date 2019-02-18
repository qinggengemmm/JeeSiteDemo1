/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.real.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.real.entity.RealGift;

/**
 * 实物奖励DAO接口
 * @author mds
 * @version 2019-02-18
 */
@MyBatisDao
public interface RealGiftDao extends CrudDao<RealGift> {
	
}