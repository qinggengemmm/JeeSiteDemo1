/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.feedback.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.feedback.entity.Feedback;
import com.jeesite.modules.feedback.dao.FeedbackDao;

/**
 * 问题反馈Service
 * @author mds
 * @version 2019-02-14
 */
@Service
@Transactional(readOnly=true)
public class FeedbackService extends CrudService<FeedbackDao, Feedback> {
	
	/**
	 * 获取单条数据
	 * @param feedback
	 * @return
	 */
	@Override
	public Feedback get(Feedback feedback) {
		return super.get(feedback);
	}
	
	/**
	 * 查询分页数据
	 * @param feedback 查询条件
	 * @param feedback.page 分页对象
	 * @return
	 */
	@Override
	public Page<Feedback> findPage(Feedback feedback) {
		return super.findPage(feedback);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param feedback
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Feedback feedback) {
		super.save(feedback);
	}
	
	/**
	 * 更新状态
	 * @param feedback
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Feedback feedback) {
		super.updateStatus(feedback);
	}
	
	/**
	 * 删除数据
	 * @param feedback
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Feedback feedback) {
		super.delete(feedback);
	}
	
}