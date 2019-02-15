/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.feedback.web;

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
import com.jeesite.modules.feedback.entity.Feedback;
import com.jeesite.modules.feedback.service.FeedbackService;

/**
 * 问题反馈Controller
 * @author mds
 * @version 2019-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/feedback/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Feedback get(Long number, boolean isNewRecord) {
		return feedbackService.get(String.valueOf(number), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("feedback:feedback:view")
	@RequestMapping(value = {"list", ""})
	public String list(Feedback feedback, Model model) {
		model.addAttribute("feedback", feedback);
		return "modules/feedback/feedbackList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("feedback:feedback:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Feedback> listData(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
		feedback.setPage(new Page<>(request, response));
		Page<Feedback> page = feedbackService.findPage(feedback);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("feedback:feedback:view")
	@RequestMapping(value = "form")
	public String form(Feedback feedback, Model model) {
		model.addAttribute("feedback", feedback);
		return "modules/feedback/feedbackForm";
	}

	/**
	 * 保存问题反馈
	 */
	@RequiresPermissions("feedback:feedback:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Feedback feedback) {
		feedbackService.save(feedback);
		return renderResult(Global.TRUE, text("保存问题反馈成功！"));
	}
	
	/**
	 * 删除问题反馈
	 */
	@RequiresPermissions("feedback:feedback:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Feedback feedback) {
		feedbackService.delete(feedback);
		return renderResult(Global.TRUE, text("删除问题反馈成功！"));
	}

	@RequiresPermissions("feedback:feedback:edit")
	@RequestMapping(value = "deleteMuti")
	@ResponseBody
	public String deleteMuti(Feedback feedback) {
		feedbackService.delete(feedback);
		return renderResult(Global.TRUE, text("删除问题反馈成功！"));
	}
	
}