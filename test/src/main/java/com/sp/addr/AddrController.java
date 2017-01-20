package com.sp.addr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("addr.addrController")
public class AddrController {
	
	@RequestMapping(value="/addr/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu2.addr.list";
	}

}
