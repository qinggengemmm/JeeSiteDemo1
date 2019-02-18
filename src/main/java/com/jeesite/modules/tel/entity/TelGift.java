/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tel.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 话费奖励Entity
 * @author mds
 * @version 2019-02-18
 */
@Table(name="tel_gift", alias="a", columns={
		@Column(name="number", attrName="number", label="number", isPK=true),
		@Column(name="match_id", attrName="matchId", label="match_id"),
		@Column(name="game_type", attrName="gameType", label="game_type"),
		@Column(name="tel_bill", attrName="telBill", label="tel_bill"),
		@Column(name="receiver", attrName="receiver", label="receiver"),
		@Column(name="operators", attrName="operators", label="operators"),
		@Column(name="tel", attrName="tel", label="tel"),
		@Column(name="gift_status", attrName="giftStatus", label="gift_status"),
	}, orderBy="a.number DESC"
)
public class TelGift extends DataEntity<TelGift> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// number
	private Long matchId;		// match_id
	private String gameType;		// game_type
	private String telBill;		// tel_bill
	private String receiver;		// receiver
	private String operators;		// operators
	private Long tel;		// tel
	private String giftStatus;		// gift_status
	
	public TelGift() {
		this(null);
	}

	public TelGift(String id){
		super(id);
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	@NotNull(message="match_id不能为空")
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}
	
	@Length(min=0, max=255, message="game_type长度不能超过 255 个字符")
	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	
	@Length(min=0, max=255, message="tel_bill长度不能超过 255 个字符")
	public String getTelBill() {
		return telBill;
	}

	public void setTelBill(String telBill) {
		this.telBill = telBill;
	}
	
	@Length(min=0, max=255, message="receiver长度不能超过 255 个字符")
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@Length(min=0, max=255, message="operators长度不能超过 255 个字符")
	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}
	
	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=255, message="gift_status长度不能超过 255 个字符")
	public String getGiftStatus() {
		return giftStatus;
	}

	public void setGiftStatus(String giftStatus) {
		this.giftStatus = giftStatus;
	}
	
}