package com.sp.notice;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.MyUtil;
import com.sp.staff.SessionInfo;

@Controller("notice.noticeController")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@Autowired
	private MyUtil myUtil;
	
	@RequestMapping(value="/notice/list")
	public String list(
				@RequestParam(value="page", defaultValue="1") int current_page,
				@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
				@RequestParam(value="searchValue", defaultValue="") String searchValue,
				Model model,
				HttpServletRequest req,
				HttpSession session
				) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		
		if (info == null)
			return "redirect:/staff/login";
		
		String cp = req.getContextPath();
		
		int numPerPage = 10, total_page = 0, dataCount = 0;
		
		if (req.getMethod().equalsIgnoreCase("GET"))
			searchValue = URLDecoder.decode(searchValue, "utf-8");
		
		// 전체 페이지 수
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		
		dataCount = service.dataCount(map);
		
		if ( dataCount != 0)
			total_page = myUtil.pageCount(numPerPage, dataCount);
		
		// 다른 사람이 자료를 삭제해서 전체 페이지수가 변한 경우
		if (total_page < current_page)
			current_page = total_page;
		
		// 1페이지인 경우 공지리스트 가져오기
		List<Notice> noticeList = null;
		
		if (current_page == 1)
			noticeList = service.listNoticeTop();
		
		// 리스트에 출력 할 데이터 가져오기
		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;
		
		map.put("start", start);
		map.put("end", end);
		
		// 글 리스트
		List<Notice> list = service.listNotice(map);
		
		// 리스트 번호 메기기
		Date endDate = new Date();
		
		long gap;
		
		int listNum, n = 0;
		
		Iterator<Notice> it = list.iterator();
		
		while (it.hasNext())
		{
			Notice data = (Notice)it.next();
			
			listNum = dataCount - (start + n -1);
			
			data.setListNum(listNum);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date beginDate = format.parse(data.getCreated());
			
			gap = (endDate.getTime() - beginDate.getTime() / (60*60*1000));
			
			data.setGap(gap);
			
			data.setCreated(data.getCreated().substring(0,10));
			
			n++;
		}
		
		String params = "";
		String urlList = cp + "/notice/list";
		String urlArticle = cp + "/notice/article?page=" + current_page;
		
		if (params.length() != 0)
		{
            urlList = cp + "/notice/list?" + params;
            
            urlArticle = cp + "/notice/article?page=" + current_page + "&" + params;
		}
		
		String paging = myUtil.paging(current_page, total_page, urlList);
		
		String name = info.getName();
		
		model.addAttribute("subMenu","2");
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("list", list);
		model.addAttribute("name",name);
		model.addAttribute("urlArticle", urlArticle);
		model.addAttribute("page", current_page);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("paging", paging);

		return ".four.menu1.notice.list";
	}
	
	@RequestMapping(value="/notice/created", method=RequestMethod.GET)
	public String createdForm(Model model, HttpSession session) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		
		if (info == null)
			return "redirect:/staff/login";
		
		if (info.getAuthor() < 5)
			return "redirect:/notice/list";
		
		model.addAttribute("mode", "created");
		model.addAttribute("subMenu", "2");
		
		return ".four.menu1.notice.created";
	}
	
	@RequestMapping(value="/notice/created", method=RequestMethod.POST)
	public String createdSubmit(Notice dto, HttpSession session) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		
		if (info == null)
			return "redirect:/member/list";
		
		if (info.getAuthor() < 5)
			return "redirect:/notice/list";
		
		dto.setS_num(info.getS_num());
		
		service.insertNotice(dto);
		
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/notice/article", method=RequestMethod.GET)
	public String article(
			@RequestParam(value="num") int num,
			@RequestParam(value="page") String page,
			@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			Model model,
			HttpSession session 
				) throws Exception
	{
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		
		if (info == null)
			return "redirect:/staff/login";
		
		searchValue = URLDecoder.decode(searchValue, "utf-8");
		
		service.updateHitCount(num);
		
		Notice dto = service.readNotice(num);
		
		if (dto == null)
			new ModelAndView("redirect:/notice/list?page=" + page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		map.put("num", num);

		Notice preReadDto = service.preReadNotice(map);
		Notice nextReadDto = service.nextReadNotice(map);
		
		String params = "page=" + page;
		
		if(searchValue.length()!=0)
		    params += "&searchKey=" + searchKey + "&searchValue=" + URLEncoder.encode(searchValue, "utf-8");
		
		String name = info.getName();
		
		model.addAttribute("subMenu", "2");
		model.addAttribute("dto", dto);
		model.addAttribute("name", name);
		model.addAttribute("preReadDto", preReadDto);
		model.addAttribute("nextReadDto", nextReadDto);
		model.addAttribute("page", page);
		model.addAttribute("params", params);
		
		return ".four.menu1.notice.article";
	}

}
