package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.dao.AdminInfoDAO;
import com.library.entity.AdminInfoEntity;

@Service
public class AdminService {

	@Autowired
	AdminInfoDAO adminInfoDAO;
	
	public AdminInfoEntity validateAdminByEmailIdAndPassword(String emailId,String password)
	{
		return adminInfoDAO.findByAdminEmailidAndPassword(emailId, password);
	}
}
