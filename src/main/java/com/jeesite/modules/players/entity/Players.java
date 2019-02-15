/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.players.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * playersEntity
 * @author mds
 * @version 2019-02-13
 */
@Table(name="players", alias="a", columns={
		@Column(name="coid", attrName="coid", label="coid", isPK=true),
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="昵称"),
		@Column(name="cretime", attrName="cretime", label="创建时间"),
		@Column(name="costatus", attrName="costatus", label="账户状态"),
		@Column(name="ls", attrName="ls", label="灵石"),
		@Column(name="yj", attrName="yj", label="驿卷"),
		@Column(name="tgy", attrName="tgy", label="通关印"),
		@Column(name="isonline", attrName="isonline", label="是否在线"),
	}, orderBy="a.coid DESC, a.number DESC"
)
public class Players extends DataEntity<Players> {
	
	private static final long serialVersionUID = 1L;
	private Long coid;		// coid
	private Long number;		// 编号
	private String name;       //昵称
	private Date cretime;		// 创建时间
	private Integer costatus;		// 账户状态
	private Long ls;		// 灵石
	private Long yj;		// 驿卷
	private Long tgy;		// 通关印
	private String isonline;		// 是否在线
	
	public Players() {

	}

	public Players(Long coid, Long number){
		this.coid = coid;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getCoid() {
		return coid;
	}

	public void setCoid(Long coid) {
		this.coid = coid;
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCretime() {
		return cretime;
	}

	public void setCretime(Date cretime) {
		this.cretime = cretime;
	}
	
	public Integer getCostatus() {
		return costatus;
	}

	public void setCostatus(Integer costatus) {
		this.costatus = costatus;
	}
	
	public Long getLs() {
		return ls;
	}

	public void setLs(Long ls) {
		this.ls = ls;
	}
	
	public Long getYj() {
		return yj;
	}

	public void setYj(Long yj) {
		this.yj = yj;
	}
	
	public Long getTgy() {
		return tgy;
	}

	public void setTgy(Long tgy) {
		this.tgy = tgy;
	}
	
	@Length(min=0, max=255, message="是否在线长度不能超过 255 个字符")
	public String getIsonline() {
		return isonline;
	}

	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
	
}