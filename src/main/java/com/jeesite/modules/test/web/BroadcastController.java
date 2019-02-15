package com.jeesite.modules.test.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "${adminPath}/test/broadcast")
public class BroadcastController {

    @GetMapping("/sendContent")
    public String home(@RequestParam(defaultValue = "") String broadcastContent){
        //TODO 发送内容给客户端

        return "modules/test/broadcast/sendSucess";
    }

    @GetMapping("/login")
    public String index(){
        return "admin/menu";
    }

    @GetMapping("/send")
    public String getMenu(){
        //TODO 发送内容给客户端
        System.out.println("到这里了");
        return "modules/test/broadcast/broadcast";
    }
}
