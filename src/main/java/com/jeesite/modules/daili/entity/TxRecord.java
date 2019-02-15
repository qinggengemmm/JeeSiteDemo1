/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.daili.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 代理列表Entity
 * @author mds
 * @version 2019-02-14
 */
@Table(name="tx_record", alias="a", columns={
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="dl_id", attrName="dlId.number", label="ID"),
		@Column(name="name", attrName="name", label="昵称"),
		@Column(name="tx_money", attrName="txMoney", label="提现金额"),
		@Column(name="tx_status", attrName="txStatus", label="状态"),
		@Column(name="tx_time", attrName="txTime", label="提现状态"),
	}, orderBy="a.number ASC"
)
public class TxRecord extends DataEntity<TxRecord> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 编号
	private Daili dlId;		// ID 父类
	private String name;		// 昵称
	private Long txMoney;		// 提现金额
	private String txStatus;		// 状态
	private Date txTime;		// 提现状态
	
	public TxRecord() {
		this(null);
	}


	public TxRecord(Daili dlId){
		this.dlId = dlId;
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Daili getDlId() {
		return dlId;
	}

	public void setDlId(Daili dlId) {
		this.dlId = dlId;
	}
	
	@Length(min=0, max=255, message="昵称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="提现金额长度不能超过 255 个字符")
	public Long getTxMoney() {
		return txMoney;
	}

	public void setTxMoney(Long txMoney) {
		this.txMoney = txMoney;
	}
	
	@Length(min=0, max=255, message="状态长度不能超过 255 个字符")
	public String getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTxTime() {
		return txTime;
	}

	public void setTxTime(Date txTime) {
		this.txTime = txTime;
	}
	
}