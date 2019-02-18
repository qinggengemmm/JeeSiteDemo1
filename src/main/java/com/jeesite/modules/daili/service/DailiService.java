/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.daili.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.jeesite.modules.players.dao.PlayersDao;
import com.jeesite.modules.players.entity.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.daili.entity.Daili;
import com.jeesite.modules.daili.dao.DailiDao;
import com.jeesite.modules.daili.entity.TxRecord;
import com.jeesite.modules.daili.dao.TxRecordDao;

/**
 * 代理列表Service
 * @author mds
 * @version 2019-02-14
 */
@Service
@Transactional(readOnly=true)
public class DailiService extends CrudService<DailiDao, Daili> {
	
	@Autowired
	private TxRecordDao txRecordDao;

	@Autowired
	private DailiDao dailiDao;

	@Autowired
	private PlayersDao playersDao;
	
	/**
	 * 获取单条数据
	 * @param daili
	 * @return
	 */
	@Override
	public Daili get(Daili daili) {
		Daili entity = super.get(daili);
		if (entity != null){
			TxRecord txRecord = new TxRecord(entity);
			txRecord.setStatus(TxRecord.STATUS_NORMAL);
			entity.setTxRecordList(txRecordDao.findList(txRecord));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param daili 查询条件
	 * @param daili.page 分页对象
	 * @return
	 */
	@Override
	public Page<Daili> findPage(Daili daili) {
		return super.findPage(daili);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param daili
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Daili daili) {
		super.save(daili);
		// 保存 Daili子表
		for (TxRecord txRecord : daili.getTxRecordList()){
			if (!TxRecord.STATUS_DELETE.equals(txRecord.getStatus())){
				txRecord.setDlId(daili);
				if (txRecord.getIsNewRecord()){
					txRecord.preInsert();
					txRecordDao.insert(txRecord);
				}else{
					txRecord.preUpdate();
					txRecordDao.update(txRecord);
				}
			}else{
				txRecordDao.delete(txRecord);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param daili
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Daili daili) {
		super.updateStatus(daili);
	}
	
	/**
	 * 删除数据
	 * @param daili
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Daili daili) {
		super.delete(daili);
		TxRecord txRecord = new TxRecord();
		txRecord.setDlId(daili);
		txRecordDao.delete(txRecord);
	}

	@Transactional(readOnly=false)
	public String addDaiLi(Long coid) {
		Daili daili = dailiDao.isDaiLi(coid);
		String yqm=getyqm();
		if (daili!=null){
			return null;
		}else {
			Players players =  playersDao.getPlayerById(coid);
			Daili newDaiLi = new Daili();
			newDaiLi.setIsNewRecord(true);
			newDaiLi.setMoney(0L);
			newDaiLi.setDlId(coid);
			newDaiLi.setDlTime(new Date());
			newDaiLi.setPeople(0L);
			newDaiLi.setName(players.getName());
			newDaiLi.setNumber(dailiDao.getMaxNumber()+1);
			while (dailiDao.hasCode(yqm)!=null){
				yqm=getyqm();
			}
			newDaiLi.setCode(yqm);
			super.save(newDaiLi);
		}

		return yqm;
	}

	private String getyqm() {
		Random rand=new Random();//生成随机数
		String cardNnumer="";
		for(int a=0;a<6;a++){
			cardNnumer+=rand.nextInt(10);//生成6位数字
		}
		return cardNnumer;
	}
}