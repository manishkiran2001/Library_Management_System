package com.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.AdminInfoEntity;
import com.library.repository.AdminInfoRepository;

@Repository
public class AdminInfoDAO {
	@Autowired
	AdminInfoRepository adminInfoRepository;
	
	public AdminInfoEntity findByAdminEmailidAndPassword(String emailId,String password)
	{
		return adminInfoRepository.findByEmailIdAndPassword(emailId, password);
	}
}
