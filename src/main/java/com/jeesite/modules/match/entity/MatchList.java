/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.match.entity;

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
 * 比赛Entity
 * @author mds
 * @version 2019-02-19
 */
@Table(name="match_list", alias="a", columns={
		@Column(name="num", attrName="num", label="编号", isPK=true),
		@Column(name="match_id", attrName="matchId", label="比赛ID"),
		@Column(name="game_type", attrName="gameType", label="游戏类型"),
		@Column(name="match_type", attrName="matchType", label="比赛类型"),
		@Column(name="people_num", attrName="peopleNum", label="游戏人数"),
		@Column(name="gift_type", attrName="giftType", label="奖励类型"),
		@Column(name="first_gift", attrName="firstGift", label="第一名奖励"),
		@Column(name="second_gift", attrName="secondGift", label="第二名奖励"),
		@Column(name="third_gift", attrName="thirdGift", label="第三名奖励"),
		@Column(name="max_match_num", attrName="maxMatchNum", label="比赛最大局数"),
		@Column(name="start_time", attrName="startTime", label="开始时间"),
		@Column(name="pic_url", attrName="picUrl", label="奖励图片地址"),
	}, orderBy="a.num DESC"
)
public class MatchList extends DataEntity<MatchList> {
	
	private static final long serialVersionUID = 1L;
	private Long num;		// 编号
	private Long matchId;		// 比赛ID
	private String gameType;		// 游戏类型
	private String matchType;		// 比赛类型
	private Long peopleNum;		// 游戏人数
	private String giftType;		// 奖励类型
	private String firstGift;		// 第一名奖励
	private String secondGift;		// 第二名奖励
	private String thirdGift;		// 第三名奖励
	private Long maxMatchNum;		// 比赛最大局数
	private Date startTime;		// 开始时间
	private String picUrl;		// 奖励图片地址
	
	public MatchList() {
		this(null);
	}

	public MatchList(String id){
		super(id);
	}
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}
	
	@Length(min=0, max=255, message="游戏类型长度不能超过 255 个字符")
	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	
	@Length(min=0, max=255, message="比赛类型长度不能超过 255 个字符")
	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
	public Long getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Long peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	@Length(min=0, max=255, message="奖励类型长度不能超过 255 个字符")
	public String getGiftType() {
		return giftType;
	}

	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	
	@Length(min=0, max=255, message="第一名奖励长度不能超过 255 个字符")
	public String getFirstGift() {
		return firstGift;
	}

	public void setFirstGift(String firstGift) {
		this.firstGift = firstGift;
	}
	
	@Length(min=0, max=255, message="第二名奖励长度不能超过 255 个字符")
	public String getSecondGift() {
		return secondGift;
	}

	public void setSecondGift(String secondGift) {
		this.secondGift = secondGift;
	}
	
	@Length(min=0, max=255, message="第三名奖励长度不能超过 255 个字符")
	public String getThirdGift() {
		return thirdGift;
	}

	public void setThirdGift(String thirdGift) {
		this.thirdGift = thirdGift;
	}
	
	public Long getMaxMatchNum() {
		return maxMatchNum;
	}

	public void setMaxMatchNum(Long maxMatchNum) {
		this.maxMatchNum = maxMatchNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Length(min=0, max=255, message="奖励图片地址长度不能超过 255 个字符")
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}