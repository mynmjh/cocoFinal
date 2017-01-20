package com.sp.webhd;

import java.util.List;
import java.util.Map;

public interface WebhdService {
	public int insertWebhd(Webhd dto, String pathname);
	public int dataCount(Map<String, Object> map);
	public List<Webhd> listWebhd(Map<String, Object> map);
	public List<Webhd> listCategory();
	public int updateHitCount(int num);
	public Webhd readWebhd(int num);
	public Webhd preReadWebhd(Map<String, Object> map);
	public Webhd nextReadWebhd(Map<String, Object> map);
	public int updateWebhd(Webhd dto, String pathname);
	public int deleteWebhd(int num, String pathname);
	public List<Webhd> listFile(int num);
	public Webhd readFile(int fileNum);
	public int deleteFile(Map<String, Object> map);

}
