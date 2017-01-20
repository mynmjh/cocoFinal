package com.sp.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.staff.SessionInfo;
import com.sp.talk.Talk;
import com.sp.talk.TalkService;

@Controller("mainController")
public class MainController {
	
	@Autowired
	TalkService service;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String method(Model model, HttpSession session) {
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		int dataCount = service.dataCount();
		List<Talk> list = service.listTalk();
		
		int s_num = info.getS_num();
		
		model.addAttribute("s_num", s_num);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("list", list);
		model.addAttribute("subMenu", "2");
		
		return ".mainLayout";
	}
}
