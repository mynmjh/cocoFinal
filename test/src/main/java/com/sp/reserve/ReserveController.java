package com.sp.reserve;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("reserve.reserveController")
public class ReserveController {
	
	@RequestMapping(value="/reserve/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu3.reserve.list";
	}

}
