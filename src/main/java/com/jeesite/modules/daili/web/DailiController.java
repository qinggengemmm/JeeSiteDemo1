/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.daili.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.daili.entity.TxRecord;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.daili.entity.Daili;
import com.jeesite.modules.daili.service.DailiService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 代理列表Controller
 * @author mds
 * @version 2019-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/daili/daili")
public class DailiController extends BaseController {

	@Autowired
	private DailiService dailiService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Daili get(Long number, boolean isNewRecord) {
		return dailiService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("daili:daili:view")
	@RequestMapping(value = {"list", ""})
	public String list(Daili daili, Model model) {
		model.addAttribute("daili", daili);
		return "modules/daili/dailiList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("daili:daili:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Daili> listData(Daili daili, HttpServletRequest request, HttpServletResponse response) {
		daili.setPage(new Page<>(request, response));
		Page<Daili> page = dailiService.findPage(daili);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("daili:daili:view")
	@RequestMapping(value = "form")
	public String form(Daili daili, Model model) {
		model.addAttribute("daili", daili);
		return "modules/daili/dailiForm";
	}

	/**
	 * 保存代理列表
	 */
	@RequiresPermissions("daili:daili:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save( @Validated Daili daili,@RequestParam(defaultValue = "0") String tx) {
		long txMoney = Long.valueOf(tx);
		//生成提现记录
		TxRecord newTxRecord = new TxRecord();
		newTxRecord.setDlId(daili);
		newTxRecord.setName(daili.getName());
		newTxRecord.setTxTime(new Date());
		newTxRecord.setTxMoney(txMoney);
		newTxRecord.setIsNewRecord(true);
		//根据时间获取唯一number
		String[] strNow = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString().split("-");
		String str="";
		for (String string : strNow) {
			str=str+string;
		}

		newTxRecord.setNumber(Long.valueOf(str));
		if (txMoney > daili.getMoney()){
			newTxRecord.setTxStatus("失败");
			daili.getTxRecordList().add(newTxRecord);
			dailiService.save(daili);
			return renderResult(Global.TRUE, text("提现失败"));
		}else {
			//提现操作
			newTxRecord.setTxStatus("成功");
			daili.setMoney(daili.getMoney()-txMoney);
			daili.getTxRecordList().add(newTxRecord);
			dailiService.save(daili);
			return renderResult(Global.TRUE, text("提现成功成功！"));

		}


	}
	
	/**
	 * 删除代理列表
	 */
	@RequiresPermissions("daili:daili:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Daili daili) {
		dailiService.delete(daili);
		return renderResult(Global.TRUE, text("删除代理列表成功！"));
	}
	
}