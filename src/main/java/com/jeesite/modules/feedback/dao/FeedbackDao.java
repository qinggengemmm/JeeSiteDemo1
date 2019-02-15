/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.feedback.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.feedback.entity.Feedback;

/**
 * 问题反馈DAO接口
 * @author mds
 * @version 2019-02-14
 */
@MyBatisDao
public interface FeedbackDao extends CrudDao<Feedback> {
	
}