package com.sp.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.common.dao.CommonDAO;

@Service("bbs.boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private CommonDAO dao;

	//글쓰기.
	@Override
	public int insertBoard(Board dto) {

		int result = 0;

		try {
			result = dao.insertData("bbs.insertBoard", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	//데이터개수
	@Override
	public int dataCount(Map<String, Object> map) {
		int result = 0;

		try {
			result = dao.getIntValue("bbs.dataCount", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	//글목록
	@Override
	public List<Board> listBoard(Map<String, Object> map) {

		List<Board> list = null;

		try {

			list = dao.getListData("bbs.listBoard", map);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}
	
	//글 삭제
	@Override
	public int deleteBoard(int num) {
		int result = 0;

		try {
			result = dao.deleteData("bbs.deleteBoard", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	//글 수정
	@Override
	public int updateBoard(Board dto) {
		int result = 0;

		try {
			result = dao.updateData("bbs.updateBoard", dto);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	//조회수증가
	@Override
	public int updateHitCount(int num) {
		int result = 0;

		try {
			result = dao.updateData("bbs.updateHitCount", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	//글읽기.
	@Override
	public Board readBoard(int num) {
		Board dto = null;

		try {
			dto = dao.getReadData("bbs.readBoard", num);

		} catch (Exception e) {
		}

		return dto;
	}

	//이전글
	@Override
	public Board preReadBoard(Map<String, Object> map) {
		Board dto = null;

		try {
			dto = dao.getReadData("bbs.preReadBoard", map);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
	}

	//다음글
	@Override
	public Board nextReadBoard(Map<String, Object> map) {
		Board dto = null;

		try {
			dto = dao.getReadData("bbs.nextReadBoard", map);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return dto;
	}

}
