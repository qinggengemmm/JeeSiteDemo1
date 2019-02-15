/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usertx.entity;

import javax.validation.constraints.NotNull;
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
 * 玩家提现记录Entity
 * @author mds
 * @version 2019-02-15
 */
@Table(name="user_tx_record", alias="a", columns={
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="us_id", attrName="usId", label="ID"),
		@Column(name="name", attrName="name", label="昵称"),
		@Column(name="txyj", attrName="txyj", label="提现驿卷"),
		@Column(name="yjtx_status", attrName="yjtxStatus", label="提现状态"),
		@Column(name="yjtx_time", attrName="yjtxTime", label="驿卷提现时间"),
	}, orderBy="a.number DESC"
)
public class UserTxRecord extends DataEntity<UserTxRecord> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 编号
	private Long usId;		// ID
	private String name;		// 昵称
	private Long txyj;		// 提现驿卷
	private String yjtxStatus;		// 提现状态
	private Date yjtxTime;		// 驿卷提现时间
	
	public UserTxRecord() {
		this(null);
	}

	public UserTxRecord(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	@NotNull(message="ID不能为空")
	public Long getUsId() {
		return usId;
	}

	public void setUsId(Long usId) {
		this.usId = usId;
	}
	
	@Length(min=0, max=255, message="昵称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getTxyj() {
		return txyj;
	}

	public void setTxyj(Long txyj) {
		this.txyj = txyj;
	}
	
	@Length(min=0, max=255, message="提现状态长度不能超过 255 个字符")
	public String getYjtxStatus() {
		return yjtxStatus;
	}

	public void setYjtxStatus(String yjtxStatus) {
		this.yjtxStatus = yjtxStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYjtxTime() {
		return yjtxTime;
	}

	public void setYjtxTime(Date yjtxTime) {
		this.yjtxTime = yjtxTime;
	}
	
}