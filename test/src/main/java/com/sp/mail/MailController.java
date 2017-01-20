package com.sp.mail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mail.mailController")
public class MailController {
	
	@RequestMapping(value="/mail/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu1.mail.list";
	}

}
