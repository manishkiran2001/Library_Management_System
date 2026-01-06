package com.library.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.UserInfoEntity;
import com.library.repository.UserInfoRepository;

@Repository
public class UserInfoDAO {

	@Autowired
	UserInfoRepository userInfoRepo;

	public UserInfoEntity insertUserInfo(UserInfoEntity userInfoEntity) {
		return userInfoRepo.save(userInfoEntity);
	}
	
	public UserInfoEntity userLogin(String emailId,String password)
	{
		return userInfoRepo.findByEmailIdAndPassword(emailId, password);
	}
	
	public UserInfoEntity getUserById(int userId)
	{
		return userInfoRepo.findByUserId(userId);
	}
}
