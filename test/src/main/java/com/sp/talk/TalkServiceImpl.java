package com.sp.talk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.common.dao.CommonDAO;

@Service("say.sayService")
public class TalkServiceImpl implements TalkService{

	@Autowired
	private CommonDAO dao;
	
	@Override
	public int insertTalk(Talk talk) {
		int result = 0;
		try {
			result = dao.insertData("talk.insertTalk", talk);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	@Override
	public List<Talk> listTalk() {
		List<Talk> list = null;
		try {
			list = dao.getListData("talk.listTalk");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	@Override
	public int deleteTalk(int num) {
		int result = 0;
		try {
			result = dao.deleteData("talk.deleteTalk", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	@Override
	public int dataCount() {
		int result = 0;
		try {
			result = dao.getIntValue("talk.dataCount");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

}
