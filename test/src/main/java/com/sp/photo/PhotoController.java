package com.sp.photo;

import java.io.File;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.common.MyUtil;
import com.sp.staff.SessionInfo;


@Controller("photo.photoController")
public class PhotoController {
	@Autowired
	private PhotoService service;
	@Autowired
	private MyUtil myUtil;

	@RequestMapping(value="/photo/list")
	public String list(
			@RequestParam(value="page", defaultValue="1") int current_page,
			@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			Model model,
			HttpServletRequest req
			) throws Exception{

		String cp = req.getContextPath();

		int numPerPage = 6;
		int total_page;
		int dataCount;

		if(req.getMethod().equalsIgnoreCase("GET")) { // GET 방식인 경우
			searchValue = URLDecoder.decode(searchValue, "utf-8");
		}
		
        // 전체 페이지 수
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchKey", searchKey);
        map.put("searchValue", searchValue);

		dataCount = service.dataCount(map);
		total_page = myUtil.pageCount(numPerPage, dataCount);

		if (total_page < current_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		map.put("start", start);
		map.put("end", end);

		List<Photo> list = service.listPhoto(map);

		// 글번호 만들기
//		int listNum, n = 0;
//		Iterator<Photo> it = list.iterator();
//		while (it.hasNext()) {
//			Photo data = it.next();
//			listNum = dataCount - (start + n - 1);
//			data.setListNum(listNum);
//			n++;
//		}

        String params = "";
        String urlList = cp+"/photo/list";
        String urlArticle = cp+"/photo/article?page=" + current_page;
        if(searchValue.length()!=0) {
        	params = "searchKey=" +searchKey + 
        	             "&searchValue=" + URLEncoder.encode(searchValue, "utf-8");	
        }
        
        if(params.length()!=0) {
            urlList = cp+"/photo/list?" + params;
            urlArticle = cp+"/photo/article?page=" + current_page + "&"+ params;
        }
		
        String paging = myUtil.paging(current_page, total_page, urlList);
        		
		model.addAttribute("subMenu", "2");
		
		model.addAttribute("list", list);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("total_page", total_page);
		model.addAttribute("urlArticle", urlArticle);
		model.addAttribute("page", current_page);
		model.addAttribute("paging", paging);
		
		return ".four.menu2.photo.list";
	}

	@RequestMapping(value="/photo/created", 
			method=RequestMethod.GET)
	public String createdForm(
			Model model,
			HttpSession session) throws Exception{
		
		SessionInfo info=
				(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}

		model.addAttribute("subMenu", "2");
		
		model.addAttribute("mode", "created");
		return ".four.menu2.photo.created";
	}
	
	@RequestMapping(value="/photo/created",
			method=RequestMethod.POST)
	public String createdSubmit(
			Photo dto,
			Model model,
			HttpSession session) throws Exception {
		String root=session.getServletContext().getRealPath("/");
		String path=root+File.separator+"uploads"+File.separator+"photo";
		
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}
		
		dto.setS_num(info.getS_num());
		service.insertPhoto(dto, path);
		
		return "redirect:/photo/list";
	}
	
	@RequestMapping(value="/photo/article", 
			method=RequestMethod.GET)
	public String article(
			@RequestParam(value="num") int num,
			@RequestParam(value="page") String page,
			@RequestParam(value="searchKey", defaultValue="subject") String searchKey,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			Model model,
			HttpSession session) throws Exception{
		
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}
		
		Photo dto = service.readPhoto(num);
		if (dto == null)
			return "redirect:/photo/list?page="+page;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
		
		// 이전 글, 다음 글
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		map.put("num", num);

		Photo preReadDto = service.preReadPhoto(map);
		Photo nextReadDto = service.nextReadPhoto(map);
        
		String params = "page="+page;
		if(searchValue.length()!=0) {
		    params += "&searchKey=" + searchKey + 
		              "&searchValue=" + URLEncoder.encode(searchValue, "utf-8");
		}
		
		model.addAttribute("subMenu", "2");
		
		model.addAttribute("dto", dto);
		model.addAttribute("preReadDto", preReadDto);
		model.addAttribute("nextReadDto", nextReadDto);
		
		model.addAttribute("page", page);
		model.addAttribute("params", params);
		
		return ".four.menu2.photo.article";
	}
	
	@RequestMapping(value="/photo/update", 
			method=RequestMethod.GET)
	public String updateForm(
			@RequestParam int num,
			@RequestParam String page,
			Model model,
			HttpSession session) throws Exception{
		
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}
		
		Photo dto = service.readPhoto(num);
		if (dto == null)
			return "redirect:/photo/list?page="+page;

		// 글을 등록한 사람만 수정 가능
		if(dto.getS_num()!=info.getS_num()) {
			return "redirect:/photo/list?page="+page;
		}
		
		model.addAttribute("subMenu", "2");
		
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		model.addAttribute("mode", "update");
		
		return ".four.menu2.photo.created";
	}
	
	@RequestMapping(value="/photo/update",
			method=RequestMethod.POST)
	public String updateSubmit(
			Photo dto,
			String page,
			HttpSession session) throws Exception {
		String root=session.getServletContext().getRealPath("/");
		String pathname=root+File.separator+"uploads"+File.separator+"photo";
		
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}
		
		// 수정하기
		service.updatePhoto(dto, pathname);
		
		// return "redirect:/photo/list?page="+page;
		return "redirect:/photo/article?num="+dto.getNum()+"&page="+page;
	}
	
	@RequestMapping(value="/photo/delete",
			method=RequestMethod.GET)
	public String delete(
			@RequestParam int num,
			@RequestParam String page,			
			HttpSession session) throws Exception {
		
		String root=session.getServletContext().getRealPath("/");
		String pathname=root+File.separator+"uploads"+File.separator+"photo";
		
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		if(info==null) {
			return "redirect:/staff/login";
		}
		
		Photo dto = service.readPhoto(num);
		if (dto == null)
			return "redirect:/photo/list?page="+page;

		// admin과 글을 등록한 사람만 삭제 가능
		if( dto.getS_num()!=info.getS_num() /*&& ! info.getUserId().equals("admin")*/) {
			return "redirect:/photo/list?page="+page;
		}
		
		// 게시물 지우기
		service.deletePhoto(num, dto.getImageFilename(), pathname);
		
		return "redirect:/photo/list?page="+page;
	}	
	
	// 댓글 처리...................................
	// 댓글 리스트
	@RequestMapping(value="/photo/listReply")
	public String listReply(
			@RequestParam int num,
			@RequestParam(value="pageNo", defaultValue="1") int current_page,
			Model model) throws Exception {
		
		int numPerPage=5;
		int total_page=0;
		int dataCount=0;
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		
		dataCount=service.replyDataCount(map);
		total_page=myUtil.pageCount(numPerPage, dataCount);
		if(current_page>total_page)
			current_page=total_page;
		
		// 리스트에 출력할 데이터
		int start=(current_page-1)*numPerPage+1;
		int end=current_page*numPerPage;
		map.put("start", start);
		map.put("end", end);
		List<Reply> listReply=service.listReply(map);
		
		// 엔터를 <br>
		Iterator<Reply> it=listReply.iterator();
		int listNum, n=0;
		while(it.hasNext()) {
			Reply dto=it.next();
			listNum=dataCount-(start+n-1);
			dto.setListNum(listNum);
			dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
			n++;
		}
		
		// 페이징처리(인수2개 짜리 js로 처리)
		String paging=myUtil.paging(current_page, total_page);
		
		// jsp로 넘길 데이터
		model.addAttribute("listReply", listReply);
		model.addAttribute("pageNo", current_page);
		model.addAttribute("replyCount", dataCount);
		model.addAttribute("total_page", total_page);
		model.addAttribute("paging", paging);
		
		return "menu2/photo/listReply";
	}

	// 댓글별 답글 리스트
	@RequestMapping(value="/photo/listReplyAnswer")
	public String listReplyAnswer(
			@RequestParam int answer,
			Model model) throws Exception {
		
		List<Reply> listReplyAnswer=service.listReplyAnswer(answer);
		
		// 엔터를 <br>
		Iterator<Reply> it=listReplyAnswer.iterator();
		while(it.hasNext()) {
			Reply dto=it.next();
			dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
		}
		
		// jsp로 넘길 데이터
		model.addAttribute("listReplyAnswer", listReplyAnswer);
		
		return "menu2/photo/listReplyAnswer";
	}
	
	// 댓글별 답글 개수
	@RequestMapping(value="/photo/replyCountAnswer",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> replyCountAnswer(
			@RequestParam int answer) throws Exception {
		
		int count=0;
		
		count=service.replyCountAnswer(answer);
		
   	    // 작업 결과를 json으로 전송
		Map<String, Object> model = new HashMap<>(); 
		model.put("count", count);
		return model;
	}
	
	// 댓글 및 리플별 답글 추가
	@RequestMapping(value="/photo/createdReply",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createdReply(
			Reply dto,
			HttpSession session) throws Exception {
	
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		
		String state="true";
		if(info==null) { // 로그인이 되지 않는 경우
			state="loginFail";
		} else {
			dto.setS_num(info.getS_num());
			int result=service.insertReply(dto);
			if(result==0)
				state="false";
		}
		
   	    // 작업 결과를 json으로 전송
		Map<String, Object> model = new HashMap<>(); 
		model.put("state", state);
		return model;
	}
	
	// 댓글 및 댓글별답글 삭제
	@RequestMapping(value="/photo/deleteReply",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteReply(
			@RequestParam int replyNum,
			@RequestParam String mode,
			HttpSession session) throws Exception {
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		
		String state="true";
		if(info==null) { // 로그인이 되지 않는 경우
			state="loginFail";
		} else {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mode", mode);
			map.put("replyNum", replyNum);

			// 좋아요/싫어요 는 ON DELETE CASCADE 로 자동 삭제

            // 댓글삭제
			int result=service.deleteReply(map);

			if(result==0)
				state="false";
		}
		
		// 작업 결과를 json으로 전송
		Map<String, Object> model = new HashMap<>(); 
		model.put("state", state);
		return model;
	}
	
	// 좋아요/싫어요 추가
	@RequestMapping(value="/photo/replyLike",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> replyLike(
			Reply dto,
			HttpSession session) throws Exception {
	
		SessionInfo info=(SessionInfo)session.getAttribute("staff");
		
		String state="true";
		if(info==null) { // 로그인이 되지 않는 경우
			state="loginFail";
		} else {
			dto.setS_num(info.getS_num());
			int result=service.insertReplyLike(dto);
			if(result==0)
				state="false";
		}
		
		// 작업 결과를 json으로 전송
		Map<String, Object> model = new HashMap<>(); 
		model.put("state", state);
		return model;
	}
	
	// 좋아요/싫어요 개수
	@RequestMapping(value="/photo/countLike",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> countLike(
			@RequestParam int replyNum) throws Exception {
		
		int likeCount=0, disLikeCount=0;
		Map<String, Object> map=service.replyCountLike(replyNum);
		if(map!=null) {
			// resultType이 map인 경우 int는 BigDecimal로 넘어옴
			likeCount=((BigDecimal)map.get("LIKECOUNT")).intValue();
			disLikeCount=((BigDecimal)map.get("DISLIKECOUNT")).intValue();
		}
		
		Map<String, Object> model = new HashMap<>(); 
		model.put("likeCount", likeCount);
		model.put("disLikeCount", disLikeCount);
		return model;
	}
}
