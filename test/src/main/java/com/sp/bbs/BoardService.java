package com.sp.bbs;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	public int insertBoard(Board dto); 
	//글쓰기	
	public int dataCount(Map<String, Object> map);
	//글 갯수
	public List<Board> listBoard(Map<String, Object> map);
	//글목록
	public int deleteBoard(int num);
	//글삭제
	public int updateBoard(Board dto);
	//글수정
	public int updateHitCount(int num);
	//조회수증가
	public Board readBoard(int num);
	//글내용읽기
	public Board preReadBoard(Map<String, Object> map);
	public Board nextReadBoard(Map<String, Object> map);
	//이전글다음글//

}
