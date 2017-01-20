package com.sp.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("survey.surveyController")
public class SurveyController {
	
	@RequestMapping(value="/survey/list")
	public String list(Model model) throws Exception 
	{
		model.addAttribute("subMenu", "2");
		return ".four.menu2.survey.list";
	}

}
