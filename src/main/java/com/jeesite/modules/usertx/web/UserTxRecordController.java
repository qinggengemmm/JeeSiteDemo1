/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usertx.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.players.entity.Players;
import com.jeesite.modules.players.service.PlayersService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.usertx.entity.UserTxRecord;
import com.jeesite.modules.usertx.service.UserTxRecordService;

import java.util.Date;

/**
 * 玩家提现记录Controller
 * @author mds
 * @version 2019-02-15
 */
@Controller
@RequestMapping(value = "${adminPath}/usertx/userTxRecord")
public class UserTxRecordController extends BaseController {

	@Autowired
	private UserTxRecordService userTxRecordService;

	@Autowired
	private PlayersService playersService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserTxRecord get(Long number, boolean isNewRecord) {
		return userTxRecordService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */

	@RequestMapping(value = {"list", ""})
	public String list(UserTxRecord userTxRecord, Model model,String coid) {
		Players player =  playersService.getPlayerById(Long.valueOf(coid));
		model.addAttribute("player", player);
		userTxRecord.setUsId(Long.valueOf(coid));
		model.addAttribute("userTxRecord", userTxRecord);
		return "modules/usertx/userTxRecordList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserTxRecord> listData(UserTxRecord userTxRecord, HttpServletRequest request, HttpServletResponse response) {
		userTxRecord.setPage(new Page<>(request, response));
		Page<UserTxRecord> page = userTxRecordService.findPage(userTxRecord);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(UserTxRecord userTxRecord, Model model) {
		model.addAttribute("userTxRecord", userTxRecord);
		return "modules/usertx/userTxRecordForm";
	}

	/**
	 * 保存玩家提现记录
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserTxRecord userTxRecord) {
		userTxRecordService.save(userTxRecord);
		return renderResult(Global.TRUE, text("保存玩家提现记录成功！"));
	}

	/**
	 * 保存提现记录
	 * @return
	 */
	@PostMapping(value = "savetx")
	@ResponseBody
	public String savetx(Long coid,Long tx) {
		Players player = playersService.getPlayerById(coid);
		UserTxRecord userTxRecord = new UserTxRecord();
		long yj = player.getYj();
		if (yj<tx){
			return renderResult(Global.FALSE, text("提现失败！驿卷不足"));
		}else {
			player.setYj(player.getYj()-tx);
			playersService.save(player);
			userTxRecord.setUsId(player.getCoid());
			userTxRecord.setName(player.getName());
			userTxRecord.setTxyj(tx);
			userTxRecord.setYjtxStatus("成功");
			userTxRecord.setYjtxTime(new Date());
			userTxRecord.setNumber(userTxRecordService.getMaxNumber()+1);
			userTxRecord.setIsNewRecord(true);
			userTxRecordService.save(userTxRecord);
			return renderResult(Global.TRUE, text("提现成功！"));

		}
	}
	
	/**
	 * 删除玩家提现记录
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserTxRecord userTxRecord) {
		userTxRecordService.delete(userTxRecord);
		return renderResult(Global.TRUE, text("删除玩家提现记录成功！"));
	}
	
}