/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.daili.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.daili.entity.Daili;

/**
 * 代理列表DAO接口
 * @author mds
 * @version 2019-02-14
 */
@MyBatisDao
public interface DailiDao extends CrudDao<Daili> {
	Daili isDaiLi(Long usId);
	Daili hasCode(String yqm);
	Long getMaxNumber();

}