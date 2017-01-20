package com.sp.webhd;

import java.io.File;
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

import com.sp.common.FileManager;
import com.sp.common.MyUtil;
import com.sp.staff.SessionInfo;

@Controller("webhd.webhdController")
public class WebhdController {
	@Autowired
	private WebhdService service;
	@Autowired
	private MyUtil util;
	@Autowired
	private FileManager fileManager;
	
	@RequestMapping(value="/webhd/list")
	public String list(
			@RequestParam(value="page", defaultValue="1") int current_page,
			@RequestParam(value="searchKey", defaultValue="subject")String searchKey,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpSession session,
			HttpServletRequest req,
			Model model) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff"); // 로그인 막고시퍼2!!!!
		
		if(info==null) { 
			return "redirect:/staff/login"; // 로그인 막고시퍼3!!!!
		}
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		int numPerPage = 10;
		int dataCount, total_page;
		Map<String, Object> map = new HashMap<>();
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		
		// 데이터 개수
		dataCount = service.dataCount(map);
		// 전체 페이지 수 
		total_page = util.pageCount(numPerPage, dataCount);
		if(current_page>total_page)
			current_page=total_page;
		
		int start = (current_page-1)*numPerPage+1;
		int end = current_page*numPerPage;
		
		map.put("start", start);
		map.put("end", end);
		
		 // 글 리스트 
	      List<Webhd> list = service.listWebhd(map);
	      Date endDate = new Date();
	      long gap;
	      
	      // 리스트의 번호 
	      int listNum, n = 0;
	      Iterator<Webhd> it = list.iterator();
	      while(it.hasNext())
	      {
	         Webhd data = it.next();
	         listNum = dataCount - (start + n - 1);
	         data.setListNum(listNum);
	         
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	         Date beginDate = formatter.parse(data.getCreated());
	         
	         // 날짜차이 (일)
	         // 날짜차이(시간)
	         gap = (endDate.getTime() - beginDate.getTime())/(60*60*1000);
	         data.setGap(gap);
	         
	         data.setCreated(data.getCreated().substring(0,10));
	         /////////////////////
	         n++;
	      }
		
		String cp = req.getContextPath();
		String listUrl = cp+"/Webhd/list";
		String urlArticle = cp+"/Webhd/article?page="+current_page;
		
		
		String params = "";
		if(searchValue.length()!=0) {
			params = "searchKey="+searchKey;
			params += "&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
		}
		if(params.length()!=0) {
			listUrl = listUrl + "?" + params;
			urlArticle = urlArticle + "&" + params;
		}
		String paging = util.paging(current_page, total_page, listUrl);
		
		model.addAttribute("list", list);
		model.addAttribute("page",current_page);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("urlArticle", urlArticle);
		model.addAttribute("total_page", total_page);
		model.addAttribute("paging", paging);
		model.addAttribute("subMenu", "2");
		return ".four.menu3.webhd.list";
	}
	
	
	@RequestMapping(value="/webhd/created" ,method=RequestMethod.GET)
	public String createdForm(
			HttpSession session,
			Model model
			) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		if(info==null)
			return "redirect:/staff/login";
		
		
		
		model.addAttribute("subMenu","2");
		model.addAttribute("mode","created");
		return ".four.menu3.webhd.created";
	}
	
	@RequestMapping(value="/webhd/created" ,method=RequestMethod.POST)
	public String createdSubmit(
			Webhd dto,
			HttpSession session
			) throws Exception {
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		if(info==null)
			return "redirect:/staff/login";
		
		
		String root = session.getServletContext().getRealPath("/");
		String pathname = root + File.separator + "uploads" + File.separator + "staff";
		dto.setS_num(info.getS_num());
		service.insertWebhd(dto, pathname);
		
		return "redirect:/webhd/list";
	}
	

}
