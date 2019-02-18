package com.jeesite.modules.test.web;

import com.jeesite.common.config.Global;
import com.jeesite.modules.usercz.dao.UserCzRecordDao;
import com.jeesite.modules.usertx.dao.UserTxRecordDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jeesite.common.web.BaseController.text;
import static com.jeesite.common.web.http.ServletUtils.renderResult;

@Controller
@RequestMapping(value = "${adminPath}/test/delete")
public class DeleteController {

    @Autowired
    private UserTxRecordDao userTxRecordDao;

    @Autowired
    private UserCzRecordDao userCzRecordDao;

    @GetMapping("/deletePage")
    public String getDeletePage(){
        return "modules/test/deletePage";
    }

    @PostMapping(value = "deleteAll")
    @ResponseBody
    public String deleteAll(){
        userTxRecordDao.deleteAll();
        userCzRecordDao.deleteAll();
        return renderResult(Global.TRUE, text("清空数据成功！"));
    }
}
