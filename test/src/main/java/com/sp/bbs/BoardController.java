package com.sp.bbs;

import java.io.Console;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

import com.sp.common.MyUtil;
import com.sp.staff.SessionInfo;

@Controller("bbs.boardController")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private MyUtil util;
	
	@RequestMapping(value = "/bbs/list")
	public String list(
			@RequestParam(value="page", defaultValue="1") int current_page,
			@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest req,
			Model model) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")){
			searchValue = 	URLDecoder.decode(searchValue, "UTF-8");					
		}		

		int numPerPage = 7;
		int dataCount,total_page;
		Map<String, Object> map = new HashMap<>();
		
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		
		//개수
		dataCount = service.dataCount(map);
		
		//페이지수	
		total_page = util.pageCount(numPerPage, dataCount);
		
		if(current_page>total_page)
			current_page = total_page;
		
		//시작,끝
		
		int start = (current_page-1)*numPerPage+1;
		int end = current_page*numPerPage;
		
		map.put("start",start);
		map.put("end", end);
		
		//해당페이지 게시물리스트
		List<Board> list=service.listBoard(map);
		
		//글번호
		int listNum, n=0;
		Iterator<Board> it=list.iterator();
		while (it.hasNext()) {
			
			Board data = it.next();
			listNum = dataCount-(start+n-1);
			data.setListNum(listNum);
			n++;			
		}
		
		String cp = req.getContextPath();
		String listUrl = cp+"/bbs/list";
		String articleUrl = cp+"/bbs/article?page="+current_page;
		
		String params="";
		if(searchValue.length()!=0){
			params ="searchKey="+searchKey;
			params+="&searchValue="+
					URLEncoder.encode(searchValue,"UTF-8");
		}
			
		if(params.length()!=0){
			
			listUrl = listUrl+"?"+params;
			articleUrl = articleUrl+"&"+params;
		}
		
		String paging = util.paging(current_page,total_page,listUrl);
		
		model.addAttribute("list",list);
		model.addAttribute("page",current_page);
		model.addAttribute("dataCount",dataCount);
		model.addAttribute("articleUrl",articleUrl);
		model.addAttribute("paging",paging);
		model.addAttribute("subMenu", "2");
		
		return ".four.menu2.bbs.list";
	}

	//글쓰기 GET//
	@RequestMapping(value = "/bbs/created", method = RequestMethod.GET)
	public String createdForm(HttpSession session, Model model) throws Exception {

	/*	SessionInfo info = (SessionInfo) session.getAttribute("member");
		if (info == null) {
			return "redirect:/member/login";
		}*/

		model.addAttribute("subMenu", "2");
		model.addAttribute("mode", "created");
		return ".four.menu2.bbs.created";
	}
	
	//글쓰기 POST//
	@RequestMapping(value="/bbs/created", method=RequestMethod.POST)
	public String createdSubmit(
			Board dto,
			HttpSession session
			) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff"); 
		
		if(info==null){
			return "redirect:/";
		}
		
		dto.setS_num(info.getS_num()); 
		service.insertBoard(dto);
		
		return "redirect:/bbs/list";
	}

	//글읽기 
		@RequestMapping(value="/bbs/article")
		public String article(
				
				HttpSession session,
				@RequestParam int num, @RequestParam int page,
				@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
				@RequestParam(value="seasrchValue", defaultValue="") String searchValue,
				Model model) throws Exception {
		
			/*SessionInfo info = (SessionInfo)session.getAttribute("staff");
			
			if(info==null){
				return "redirect:/";
			}*/
			searchValue = 	URLDecoder.decode(searchValue, "UTF-8");			
			//hitcount
			service.updateHitCount(num);
			
			Board dto = service.readBoard(num);
			if(dto==null){
				return "redirect:/bbs/list?page="+page;
			}
			
			int linesu = dto.getContent().split("\n").length;
			dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
			
			Map<String, Object> map = new HashMap<>();
			map.put("num", num);
			map.put("searchKey", searchKey);
			map.put("searchValue", searchValue);
					
			//이전글	//다음글.
			Board preReadDto = service.preReadBoard(map);
			Board nextReadDto = service.nextReadBoard(map);
			
			String params="page="+page;
			if(searchValue.length()!=0) {
				params+="&searchKey="+searchKey;
				params+="&searchValue="
					+URLDecoder.decode(searchValue, "UTF-8");
			}		
			
			
			model.addAttribute("dto",dto);		
			model.addAttribute("preReadDto",preReadDto);
			model.addAttribute("nextReadDto",nextReadDto);
			
			model.addAttribute("linesu",linesu);
			model.addAttribute("page",page);
			model.addAttribute("params",params);
					
			model.addAttribute("subMenu", "2");
			
			return ".four.menu2.bbs.article";
		}

		
	
	//글수정 get
	@RequestMapping(value="/bbs/update", method=RequestMethod.GET)
	public String updateForm(			
			@RequestParam int num,
			@RequestParam String page,
			HttpSession session, 
			Model model) throws Exception {
		
	SessionInfo info = (SessionInfo)session.getAttribute("staff");
	/*	if(info==null){
			return "redirect:/";
		}*/
		
		Board dto = service.readBoard(num);
		if(dto==null|| dto.getS_num()!=info.getS_num()){
			System.out.println("널널널널널널널널널");
			return "redirect:/bbs/list?page="+page;
		}		
		
		model.addAttribute("subMenu", "2");	
		model.addAttribute("dto", dto);	
		model.addAttribute("page", page);	
		model.addAttribute("mode", "update");
		
		return ".four.menu2.bbs.created";
	}
	
	//글수정 post
	@RequestMapping(value="/bbs/update", method=RequestMethod.POST)
	public String updateSubmit(
			Board dto,
			HttpSession session,
			@RequestParam String page			
			) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff"); //info.
		if(info==null){
			return "redirect:/";
		}
		
		dto.setS_num(info.getS_num()); 
		service.updateBoard(dto);
		
		return "redirect:/bbs/list?page="+page;
	}
	
	
	//글 삭제
	@RequestMapping(value="/bbs/delete")
	public String delete(
			 @RequestParam int num
			,@RequestParam String page
			,@RequestParam int uid
			,HttpSession session		
			) throws Exception{		
		
		SessionInfo info = (SessionInfo)session.getAttribute("staff");
		if(info==null){
			return "redirect:/member/login";
		}
		
	if(info.getS_num()==uid){
			service.deleteBoard(num);
		}
		
		return "redirect:/bbs/list?page="+page;
	}
}
