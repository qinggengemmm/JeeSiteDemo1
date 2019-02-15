/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.daili.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 代理列表Entity
 * @author mds
 * @version 2019-02-14
 */
@Table(name="daili", alias="a", columns={
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="dl_id", attrName="dlId", label="ID"),
		@Column(name="name", attrName="name", label="昵称"),
		@Column(name="dl_time", attrName="dlTime", label="代理时间"),
		@Column(name="people", attrName="people", label="招募人数"),
		@Column(name="money", attrName="money", label="代理雇佣金"),
		@Column(name="code", attrName="code", label="代理邀请码"),
	}, orderBy="a.number DESC"
)
public class Daili extends DataEntity<Daili> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 编号
	private Long dlId;		// ID
	private String name;		// 昵称
	private Date dlTime;		// 代理时间
	private Long people;		// 招募人数
	private Long money;		// 代理雇佣金
	private String code;		// 代理邀请码
	private List<TxRecord> txRecordList = ListUtils.newArrayList();		// 子表列表
	
	public Daili() {
		this(null);
	}

	public Daili(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	@NotNull(message="ID不能为空")
	public Long getDlId() {
		return dlId;
	}

	public void setDlId(Long dlId) {
		this.dlId = dlId;
	}
	
	@Length(min=0, max=255, message="昵称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDlTime() {
		return dlTime;
	}

	public void setDlTime(Date dlTime) {
		this.dlTime = dlTime;
	}
	
	public Long getPeople() {
		return people;
	}

	public void setPeople(Long people) {
		this.people = people;
	}
	
	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}
	
	@Length(min=0, max=255, message="代理邀请码长度不能超过 255 个字符")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public List<TxRecord> getTxRecordList() {
		return txRecordList;
	}

	public void setTxRecordList(List<TxRecord> txRecordList) {
		this.txRecordList = txRecordList;
	}
	
}