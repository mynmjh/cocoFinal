package com.sp.cal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("cal.calController")
public class CalController {
	
	@RequestMapping(value="/cal/com_cal")
	public String cal(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu3.cal.com_cal";
	}

}
