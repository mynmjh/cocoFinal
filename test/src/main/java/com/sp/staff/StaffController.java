package com.sp.staff;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView loginForm() throws Exception
	{
		return new ModelAndView(".staff.login");//
	}
	
	@RequestMapping(value="/staff/login", method=RequestMethod.POST)
	public ModelAndView loginSubmit(
				HttpSession session,
				@RequestParam("s_num") int s_num,
				@RequestParam("password") String password) throws Exception
	{
		Staff dto = service.readStaff(s_num);
		
		if ( dto == null || (! dto.getPassword().equals(password)) )
		{
			ModelAndView mav = new ModelAndView(".staff.login");
			
			mav.addObject("message", "사원번호 또는 패스워드가 일치하지 않습니다.");
			
			return mav;
		}
		
		// 로그인 정보를 세션에 저장
		SessionInfo info = new SessionInfo();
		
		info.setName(dto.getName());		// 이름
		info.setB_name(dto.getB_name());	// 부서이름
		info.setP_name(dto.getP_name());	// 직위이름
		info.setS_num(dto.getS_num());		// 사원번호
		info.setAuthor(dto.getAuthor());	// 권한번호
		
		session.setAttribute("staff", info);
		
		return new ModelAndView("redirect:/main");
	}

}
