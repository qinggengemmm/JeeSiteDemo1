/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.feedback.entity;

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
 * 问题反馈Entity
 * @author mds
 * @version 2019-02-14
 */
@Table(name="feedback", alias="a", columns={
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="feedback_id", attrName="feedbackId", label="ID"),
		@Column(name="username", attrName="username", label="用户名"),
		@Column(name="feedback_time", attrName="feedbackTime", label="反馈时间"),
		@Column(name="feedback_content", attrName="feedbackContent", label="反馈内容"),
	}, orderBy="a.number DESC"
)
public class Feedback extends DataEntity<Feedback> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 编号
	private Long feedbackId;		// ID
	private String username;		// 用户名
	private Date feedbackTime;		// 反馈时间
	private String feedbackContent;		// 反馈内容
	
	public Feedback() {
		this(null);
	}

	public Feedback(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	@Length(min=0, max=255, message="用户名长度不能超过 255 个字符")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFeedbackTime() {
		return feedbackTime;
	}

	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	
	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	
}