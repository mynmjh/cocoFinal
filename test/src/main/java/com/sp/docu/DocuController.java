package com.sp.docu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("docu.docuController")
public class DocuController {
	
	@RequestMapping(value="/docu/list")
	public String list(Model model) throws Exception {

		model.addAttribute("subMenu", "2");
		return ".four.menu1.docu.list";
	}

}
