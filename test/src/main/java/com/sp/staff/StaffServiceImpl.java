package com.sp.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.common.dao.CommonDAO;

@Service("staff.staffService")
public class StaffServiceImpl implements StaffService{

	@Autowired
	private CommonDAO dao;
	
	@Override
	public Staff readStaff(int s_num)
	{
		Staff dto = null;
		
		try {
			dto = dao.getReadData("staff.readStaff",s_num);
			
		} catch (Exception e) {
		}
		
		return dto;
	}

}
