package com.sp.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.common.dao.CommonDAO;

@Service("notice.noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private CommonDAO dao;

	@Override
	public int insertNotice(Notice dto)
	{
		int result = 0;
		
		try {
			int maxNum = dao.getIntValue("notice.maxNum");
			
			dto.setNum(maxNum + 1);
			
			dao.insertData("notice.insertNotice", dto);

			result = 1;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public int dataCount(Map<String, Object> map)
	{
		int result = 0;
		
		try {
			result = dao.getIntValue("notice.dataCount", map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public List<Notice> listNotice(Map<String, Object> map)
	{
		List<Notice> list = null;
		
		try {
			list = dao.getListData("notice.listNotice", map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return list;
	}

	@Override
	public List<Notice> listNoticeTop()
	{
		List<Notice> list = null;
		
		try {
			list = dao.getListData("notice.listNoticeTop");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return list;
	}

	@Override
	public int updateHitCount(int num)
	{
		int result = 0;
		
		try {
			result = dao.updateData("notice.updateHitCount", num);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public Notice readNotice(int num)
	{
		Notice dto = null;
		
		try {
			dto = dao.getReadData("notice.readNotice", num);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}

	@Override
	public Notice preReadNotice(Map<String, Object> map)
	{
		Notice dto = null;
		
		try {
			dto = dao.getReadData("notice.preReadNotice", map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}

	@Override
	public Notice nextReadNotice(Map<String, Object> map)
	{
		Notice dto = null;
		
		try {
			dto = dao.getReadData("notice.nextReadNotice", map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}

	@Override
	public int updateNotice(Notice dto, String pathname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(int num, String pathname) {
		// TODO Auto-generated method stub
		return 0;
	}

}
