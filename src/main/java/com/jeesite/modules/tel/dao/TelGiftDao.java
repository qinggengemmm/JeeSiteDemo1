/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tel.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tel.entity.TelGift;

/**
 * 话费奖励DAO接口
 * @author mds
 * @version 2019-02-18
 */
@MyBatisDao
public interface TelGiftDao extends CrudDao<TelGift> {
	
}