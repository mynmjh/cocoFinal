package com.sp.sign;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sign.signController")
public class SignController {
	
	@RequestMapping(value="/sign/list")
	public String list(Model model) throws Exception {

		model.addAttribute("subMenu", "2");
		return ".four.menu1.sign.list";
	}

}
