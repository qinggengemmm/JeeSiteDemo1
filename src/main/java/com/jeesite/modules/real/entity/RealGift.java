/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.real.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 实物奖励Entity
 * @author mds
 * @version 2019-02-18
 */
@Table(name="real_gift", alias="a", columns={
		@Column(name="number", attrName="number", label="编号", isPK=true),
		@Column(name="match_id", attrName="matchId", label="比赛场次"),
		@Column(name="game_type", attrName="gameType", label="游戏类型"),
		@Column(name="real_thing", attrName="realThing", label="实物场"),
		@Column(name="receiver", attrName="receiver", label="收货人名称"),
		@Column(name="tel", attrName="tel", label="收货人电话"),
		@Column(name="address", attrName="address", label="收货人地址"),
		@Column(name="gift_status", attrName="giftStatus", label="奖品状态"),
	}, orderBy="a.number DESC"
)
public class RealGift extends DataEntity<RealGift> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 编号
	private Long matchId;		// 比赛场次
	private String gameType;		// 游戏类型
	private String realThing;		// 实物场
	private String receiver;		// 收货人名称
	private String tel;		// 收货人电话
	private String address;		// 收货人地址
	private String giftStatus;		// 奖品状态
	
	public RealGift() {
		this(null);
	}

	public RealGift(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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
	
	@Length(min=0, max=255, message="实物场长度不能超过 255 个字符")
	public String getRealThing() {
		return realThing;
	}

	public void setRealThing(String realThing) {
		this.realThing = realThing;
	}
	
	@Length(min=0, max=255, message="收货人名称长度不能超过 255 个字符")
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@Length(min=0, max=255, message="收货人电话长度不能超过 255 个字符")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=255, message="收货人地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=255, message="奖品状态长度不能超过 255 个字符")
	public String getGiftStatus() {
		return giftStatus;
	}

	public void setGiftStatus(String giftStatus) {
		this.giftStatus = giftStatus;
	}
	
}