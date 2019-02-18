/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.real.web;

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
import com.jeesite.modules.real.entity.RealGift;
import com.jeesite.modules.real.service.RealGiftService;

/**
 * 实物奖励Controller
 * @author mds
 * @version 2019-02-18
 */
@Controller
@RequestMapping(value = "${adminPath}/real/realGift")
public class RealGiftController extends BaseController {

	@Autowired
	private RealGiftService realGiftService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public RealGift get(Long number, boolean isNewRecord) {
		return realGiftService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("real:realGift:view")
	@RequestMapping(value = {"list", ""})
	public String list(RealGift realGift, Model model) {
		model.addAttribute("realGift", realGift);
		return "modules/real/realGiftList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("real:realGift:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<RealGift> listData(RealGift realGift, HttpServletRequest request, HttpServletResponse response) {
		realGift.setPage(new Page<>(request, response));
		Page<RealGift> page = realGiftService.findPage(realGift);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("real:realGift:view")
	@RequestMapping(value = "form")
	public String form(RealGift realGift, Model model) {
		model.addAttribute("realGift", realGift);
		return "modules/real/realGiftForm";
	}

	/**
	 * 保存实物奖励
	 */
	@RequiresPermissions("real:realGift:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated RealGift realGift) {
		realGiftService.save(realGift);
		return renderResult(Global.TRUE, text("保存实物奖励成功！"));
	}
	
	/**
	 * 删除实物奖励
	 */
	@RequiresPermissions("real:realGift:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(RealGift realGift) {
		realGiftService.delete(realGift);
		return renderResult(Global.TRUE, text("删除实物奖励成功！"));
	}

	@RequiresPermissions("real:realGift:edit")
	@RequestMapping(value = "updateGift")
	@ResponseBody
	public String updateGift(RealGift realGift) {
		if ("已发放".equals(realGift.getGiftStatus())){
			realGift.setGiftStatus("未发放");
		}else {
			realGift.setGiftStatus("已发放");

		}
		realGiftService.save(realGift);
		return renderResult(Global.TRUE, text("已变更奖品状态！"));
	}
	
}