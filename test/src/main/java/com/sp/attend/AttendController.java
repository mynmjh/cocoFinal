package com.sp.attend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("attend.attendController")
public class AttendController {
	
	@RequestMapping(value="/attend/list")
	public String list(Model model) throws Exception {

		model.addAttribute("subMenu", "2");
		return ".four.menu1.attend.list";
	}

}
