package com.sp.club;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("club.clubController")
public class ClubController {
	
	@RequestMapping(value="/club/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu2.club.list";
	}

}
