package com.sp.notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	
	public int insertNotice(Notice dto);
	public int dataCount(Map<String, Object> map);
	public List<Notice> listNotice(Map<String, Object> map);
	public List<Notice> listNoticeTop();
	public int updateHitCount(int num);
	public Notice readNotice(int num);
	public Notice preReadNotice(Map<String, Object> map);
	public Notice nextReadNotice(Map<String, Object> map);
	public int updateNotice(Notice dto, String pathname);
	public int deleteNotice(int num, String pathname);

}
