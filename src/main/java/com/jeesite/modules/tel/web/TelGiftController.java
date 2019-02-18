/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tel.web;

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
import com.jeesite.modules.tel.entity.TelGift;
import com.jeesite.modules.tel.service.TelGiftService;

/**
 * 话费奖励Controller
 * @author mds
 * @version 2019-02-18
 */
@Controller
@RequestMapping(value = "${adminPath}/tel/telGift")
public class TelGiftController extends BaseController {

	@Autowired
	private TelGiftService telGiftService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TelGift get(Long number, boolean isNewRecord) {
		return telGiftService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tel:telGift:view")
	@RequestMapping(value = {"list", ""})
	public String list(TelGift telGift, Model model) {
		model.addAttribute("telGift", telGift);
		return "modules/tel/telGiftList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tel:telGift:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TelGift> listData(TelGift telGift, HttpServletRequest request, HttpServletResponse response) {
		telGift.setPage(new Page<>(request, response));
		Page<TelGift> page = telGiftService.findPage(telGift);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tel:telGift:view")
	@RequestMapping(value = "form")
	public String form(TelGift telGift, Model model) {
		model.addAttribute("telGift", telGift);
		return "modules/tel/telGiftForm";
	}

	/**
	 * 保存话费奖励
	 */
	@RequiresPermissions("tel:telGift:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TelGift telGift) {
		telGiftService.save(telGift);
		return renderResult(Global.TRUE, text("保存话费奖励成功！"));
	}
	
	/**
	 * 删除话费奖励
	 */
	@RequiresPermissions("tel:telGift:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TelGift telGift) {
		telGiftService.delete(telGift);
		return renderResult(Global.TRUE, text("删除话费奖励成功！"));
	}

	/**
	 * 修改礼物发放状态
	 */
	@RequiresPermissions("tel:telGift:edit")
	@RequestMapping(value = "updateGift")
	@ResponseBody
	public String updateGift(TelGift telGift) {
		if ("已发放".equals(telGift.getGiftStatus())){
			telGift.setGiftStatus("未发放");
		}else {
			telGift.setGiftStatus("已发放");
		}
		telGiftService.save(telGift);
		return renderResult(Global.TRUE, text("已变更奖品状态！"));
	}
	
}