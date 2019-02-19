/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.match.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.match.entity.MatchList;

/**
 * 比赛DAO接口
 * @author mds
 * @version 2019-02-19
 */
@MyBatisDao
public interface MatchListDao extends CrudDao<MatchList> {

    Long getMaxNumber();
}