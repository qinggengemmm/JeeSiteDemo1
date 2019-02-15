/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.players.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.players.entity.Players;
import com.jeesite.modules.players.service.PlayersService;

/**
 * playersController
 * @author mds
 * @version 2019-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/players/players")
public class PlayersController extends BaseController {

	@Autowired
	private PlayersService playersService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Players get(Long coid, Long number, boolean isNewRecord) {
		return playersService.get(new Class<?>[]{Long.class, Long.class},
				new Object[]{coid, number}, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("players:players:view")
	@RequestMapping(value = {"list", ""})
	public String list(Players players, Model model) {
		model.addAttribute("players", players);
		return "modules/players/playersList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("players:players:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Players> listData(Players players, HttpServletRequest request, HttpServletResponse response) {
		players.setPage(new Page<>(request, response));
		Page<Players> page = playersService.findPage(players);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("players:players:view")
	@RequestMapping(value = "form")
	public String form(Players players, Model model) {
		model.addAttribute("players", players);
		return "modules/players/playersForm";
	}

	/**
	 * 保存players
	 */
	@RequiresPermissions("players:players:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Players players) {
		playersService.save(players);
		return renderResult(Global.TRUE, text("保存players成功！"));
	}
	
	/**
	 * 删除players
	 */
	@RequiresPermissions("players:players:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Players players) {
		playersService.delete(players);
		return renderResult(Global.TRUE, text("删除players成功！"));
	}
	
}