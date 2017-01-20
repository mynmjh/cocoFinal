package com.sp.msg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("msg.msgController")
public class MsgController {

	@RequestMapping(value="/msg/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu1.msg.list";
	}

}