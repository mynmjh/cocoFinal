package com.sp.set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("set.setController")
public class SetController {
	
	@RequestMapping(value="/set/main")
	public String info(Model model) throws Exception {

		model.addAttribute("subMenu", "1");
		return ".four.menu4.set.main";
	}

}
