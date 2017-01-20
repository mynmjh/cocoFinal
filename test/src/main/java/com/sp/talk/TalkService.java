package com.sp.talk;

import java.util.List;

public interface TalkService {
	
	public int insertTalk(Talk talk);
	public List<Talk> listTalk();
	public int dataCount();
	public int deleteTalk(int num);

}
