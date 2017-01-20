package com.sp.webhd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sp.common.FileManager;
import com.sp.common.dao.CommonDAO;

@Service("webhd.webhdService")
public class WebhdServiceImpl implements WebhdService{
	@Autowired
	private CommonDAO dao;
	@Autowired
	private FileManager fileManager;
	@Override
	public int insertWebhd(Webhd dto, String pathname) {
		int result = 0;
		
		try {
			int maxNum = dao.getIntValue("webhd.maxNum");
			dto.setNum(maxNum+1);
			
			dao.insertData("webhd.insertWebhd", dto);
			
			if(!dto.getUpload().isEmpty()) {
				for(MultipartFile mf:dto.getUpload()) {
					if(mf.isEmpty())
						continue;
					String filename = fileManager.doFileUpload(mf, pathname); // 서버에 파일 저장
					if(filename!=null) {
						dto.setSaveFilename(filename);
						dto.setOriginalFilename(mf.getOriginalFilename());
						long fileSize = mf.getSize(); // 파일 사이즈!!
						dto.setFileSize(fileSize);
						dao.insertData("webhd.insertWebhdFile", dto); // DB속에 데이터 추가(파일 개수만큼 insert가 발생)
					}
				}
			}
			result = 1;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public int dataCount(Map<String, Object> map) {
		int result = 0;
		try {
			result = dao.getIntValue("webhd.dataCount",map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	@Override
	public List<Webhd> listWebhd(Map<String, Object> map) {
		List<Webhd> dto = null;
		try {
			dto = dao.getListData("webhd.listWebhd", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	@Override
	public List<Webhd> listCategory() {
		List<Webhd>dto = null;
		try {
			dto = dao.getListData("webhd.listCategoryTop");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	@Override
	public int updateHitCount(int num) {
		int result = 0;
		try {
			result = dao.getIntValue("webhd.updateHitCount", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	@Override
	public Webhd readWebhd(int num) {
		Webhd dto = null;
		try {
			dto = dao.getReadData("webhd.readWebhd", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	@Override
	public Webhd preReadWebhd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Webhd nextReadWebhd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWebhd(Webhd dto, String pathname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWebhd(int num, String pathname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Webhd> listFile(int num) {
		List<Webhd> list = null;
		try {
			list = dao.getListData("webhd.listFile", num);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	@Override
	public Webhd readFile(int fileNum) {
		Webhd dto = null;
		try {
			dto = dao.getReadData("webhd.readFile", fileNum);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	@Override
	public int deleteFile(Map<String, Object> map) {
		int result=0;
		
		try {
			result=dao.deleteData("webhd.deleteFile", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

}
