/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.match.web;

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
import com.jeesite.modules.match.entity.MatchList;
import com.jeesite.modules.match.service.MatchListService;

/**
 * 比赛Controller
 * @author mds
 * @version 2019-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/match/matchList")
public class MatchListController extends BaseController {

	@Autowired
	private MatchListService matchListService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MatchList get(Long num, boolean isNewRecord) {
		return matchListService.get(String.valueOf(num), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("match:matchList:view")
	@RequestMapping(value = {"list", ""})
	public String list(MatchList matchList, Model model) {
		model.addAttribute("matchList", matchList);
		return "modules/match/matchListList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("match:matchList:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MatchList> listData(MatchList matchList, HttpServletRequest request, HttpServletResponse response) {
		matchList.setPage(new Page<>(request, response));
		Page<MatchList> page = matchListService.findPage(matchList);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("match:matchList:view")
	@RequestMapping(value = "form")
	public String form(MatchList matchList, Model model) {
		model.addAttribute("matchList", matchList);
		return "modules/match/matchListForm";
	}

	/**
	 * 保存比赛
	 */
	@RequiresPermissions("match:matchList:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MatchList matchList,String picurl,String secondNum,String thirdNum) {
	    Long beishu = 4L;
	    if ("斗地主".equals(matchList.getGameType())){
	        beishu=3L;
        }
	    matchList.setPicUrl(picurl);
	    matchList.setSecondGift(matchList.getSecondGift()+"*"+secondNum);
	    matchList.setThirdGift(matchList.getThirdGift()+"*"+thirdNum);
	    matchList.setPeopleNum(matchList.getPeopleNum()*beishu);
		matchListService.save(matchList);
		return renderResult(Global.TRUE, text("保存比赛成功！"));
	}
	
	/**
	 * 删除比赛
	 */
	@RequiresPermissions("match:matchList:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MatchList matchList) {
		matchListService.delete(matchList);
		return renderResult(Global.TRUE, text("删除比赛成功！"));
	}
	
}