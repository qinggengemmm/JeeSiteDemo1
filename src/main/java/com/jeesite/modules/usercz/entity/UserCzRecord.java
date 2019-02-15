/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usercz.entity;

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
 * 玩家充值记录Entity
 * @author mds
 * @version 2019-02-15
 */
@Table(name="user_cz_record", alias="a", columns={
		@Column(name="number", attrName="number", label="number", isPK=true),
		@Column(name="us_id", attrName="usId", label="us_id"),
		@Column(name="name", attrName="name", label="name"),
		@Column(name="cz_type", attrName="czType", label="cz_type"),
		@Column(name="cz_count", attrName="czCount", label="cz_count"),
		@Column(name="cz_status", attrName="czStatus", label="cz_status"),
		@Column(name="cz_time", attrName="czTime", label="cz_time"),
		@Column(name="cz_from", attrName="czFrom", label="cz_from"),
	}, orderBy="a.number DESC"
)
public class UserCzRecord extends DataEntity<UserCzRecord> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// number
	private Long usId;		// us_id
	private String name;		// name
	private String czType;		// cz_type
	private Long czCount;		// cz_count
	private String czStatus;		// cz_status
	private Date czTime;		// cz_time
	private String czFrom;		// cz_from
	
	public UserCzRecord() {
		this(null);
	}

	public UserCzRecord(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Long getUsId() {
		return usId;
	}

	public void setUsId(Long usId) {
		this.usId = usId;
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="cz_type长度不能超过 255 个字符")
	public String getCzType() {
		return czType;
	}

	public void setCzType(String czType) {
		this.czType = czType;
	}
	
	public Long getCzCount() {
		return czCount;
	}

	public void setCzCount(Long czCount) {
		this.czCount = czCount;
	}
	
	@Length(min=0, max=255, message="cz_status长度不能超过 255 个字符")
	public String getCzStatus() {
		return czStatus;
	}

	public void setCzStatus(String czStatus) {
		this.czStatus = czStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCzTime() {
		return czTime;
	}

	public void setCzTime(Date czTime) {
		this.czTime = czTime;
	}
	
	@Length(min=0, max=255, message="cz_from长度不能超过 255 个字符")
	public String getCzFrom() {
		return czFrom;
	}

	public void setCzFrom(String czFrom) {
		this.czFrom = czFrom;
	}
	
}