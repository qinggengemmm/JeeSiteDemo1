/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.match.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.match.entity.MatchList;
import com.jeesite.modules.match.dao.MatchListDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 比赛Service
 * @author mds
 * @version 2019-02-19
 */
@Service
@Transactional(readOnly=true)
public class MatchListService extends CrudService<MatchListDao, MatchList> {

	@Autowired
	private MatchListDao matchListDao;
	/**
	 * 获取单条数据
	 * @param matchList
	 * @return
	 */
	@Override
	public MatchList get(MatchList matchList) {
		return super.get(matchList);
	}
	
	/**
	 * 查询分页数据
	 * @param matchList 查询条件
	 * @param matchList.page 分页对象
	 * @return
	 */
	@Override
	public Page<MatchList> findPage(MatchList matchList) {
		return super.findPage(matchList);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param matchList
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MatchList matchList) {
		Long n = matchListDao.getMaxNumber();
		n=n==null?0:n;
		n++;
		matchList.setNum(n);
		matchList.setIsNewRecord(true);
		super.save(matchList);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(matchList.getId(), "matchList_image");
	}
	
	/**
	 * 更新状态
	 * @param matchList
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MatchList matchList) {
		super.updateStatus(matchList);
	}
	
	/**
	 * 删除数据
	 * @param matchList
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MatchList matchList) {
		super.delete(matchList);
	}
	
}