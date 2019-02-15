/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usertx.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.usertx.entity.UserTxRecord;

/**
 * 玩家提现记录DAO接口
 * @author mds
 * @version 2019-02-15
 */
@MyBatisDao
public interface UserTxRecordDao extends CrudDao<UserTxRecord> {

    Long getMaxNumber();
	
}