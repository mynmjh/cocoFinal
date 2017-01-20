package com.sp.talk;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.staff.SessionInfo;

@Controller("talk.talkController")
public class TalkController {
	
	@Autowired
	TalkService service;
	
	/*@RequestMapping(value="/talk/list")
	public String list(Model model, HttpSession session) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		int dataCount = service.dataCount();
		List<Talk> list = service.listTalk();
		
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("name", info.getName());
		model.addAttribute("list", list);
		model.addAttribute("subMenu", "2");
		return ".mainLayout";
	}*/

	@RequestMapping(value="/talk/created", method = RequestMethod.GET)
	public String createdSubmit(Talk talk, HttpSession session) throws Exception 
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff"); // 세션 객체 저장 
		if(info == null)
		{
			return "redirect:/"; // 세션 정보 없으면 로그인 해라 
		}
		
		talk.setS_num(info.getS_num());
		
		service.insertTalk(talk);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="/talk/deleteTalk", method = RequestMethod.GET)
	public String deleteTalk(@RequestParam int num, HttpSession session) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff"); // 세션 객체 저장 
		if(info == null)
		{
			return "redirect:/staff/login"; // 세션 정보 없으면 로그인 해라 
		}
		service.deleteTalk(num);
		
		return "redirect:/main";
	}

}
