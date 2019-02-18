/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usercz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.usercz.entity.UserCzRecord;

/**
 * 玩家充值记录DAO接口
 * @author mds
 * @version 2019-02-15
 */
@MyBatisDao
public interface UserCzRecordDao extends CrudDao<UserCzRecord> {
    public Long getMaxNumber();
    void deleteAll();
}