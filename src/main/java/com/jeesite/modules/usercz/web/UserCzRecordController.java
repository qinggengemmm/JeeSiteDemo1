/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.usercz.web;

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
import com.jeesite.modules.usercz.entity.UserCzRecord;
import com.jeesite.modules.usercz.service.UserCzRecordService;

import java.util.Date;

/**
 * 玩家充值记录Controller
 * @author mds
 * @version 2019-02-15
 */
@Controller
@RequestMapping(value = "${adminPath}/usercz/userCzRecord")
public class UserCzRecordController extends BaseController {

	@Autowired
	private UserCzRecordService userCzRecordService;

	@Autowired
	private PlayersService playersService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserCzRecord get(Long number, boolean isNewRecord) {
		return userCzRecordService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */

	@RequestMapping(value = {"list", ""})
	public String list(UserCzRecord userCzRecord, Model model,String coid){
		userCzRecord.setUsId(Long.valueOf(coid));
		Players player =  playersService.getPlayerById(Long.valueOf(coid));
		model.addAttribute("userCzRecord", userCzRecord);
		model.addAttribute("player", player);
		return "modules/usercz/userCzRecordList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserCzRecord> listData(UserCzRecord userCzRecord, HttpServletRequest request, HttpServletResponse response) {
		userCzRecord.setPage(new Page<>(request, response));
		Page<UserCzRecord> page = userCzRecordService.findPage(userCzRecord);
		return page;
	}

	/**
	 * 查看编辑表单
	 */

	@RequestMapping(value = "form")
	public String form(UserCzRecord userCzRecord, Model model) {
		model.addAttribute("userCzRecord", userCzRecord);
		return "modules/usercz/userCzRecordForm";
	}

	/**
	 * 保存玩家充值记录
	 */

	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserCzRecord userCzRecord) {
		userCzRecordService.save(userCzRecord);
		return renderResult(Global.TRUE, text("保存玩家充值记录成功！"));
	}

	@PostMapping(value = "savecz")
	@ResponseBody
	public String save(Long coid,Long cz) {
		Players player =  playersService.getPlayerById(Long.valueOf(coid));
		player.setYj(player.getYj()+cz);
		playersService.save(player);
		UserCzRecord userCzRecord = new UserCzRecord();
		userCzRecord.setUsId(player.getCoid());
		userCzRecord.setCzCount(cz);
		userCzRecord.setName(player.getName());
		userCzRecord.setCzFrom("后台");
		userCzRecord.setCzType("驿卷");
		userCzRecord.setCzTime(new Date());
		userCzRecord.setNumber(userCzRecordService.getMaxNumber()+1);
		userCzRecord.setCzStatus("成功");
		userCzRecord.setIsNewRecord(true);
		userCzRecordService.save(userCzRecord);
		return renderResult(Global.TRUE, text("玩家充值成功！"));
	}
	
	/**
	 * 删除玩家充值记录
	 */

	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserCzRecord userCzRecord) {
		userCzRecordService.delete(userCzRecord);
		return renderResult(Global.TRUE, text("删除玩家充值记录成功！"));
	}
	
}