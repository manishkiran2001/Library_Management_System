package com.library.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.UserInfoDAO;
import com.library.dto.UserInfoDTO;
import com.library.entity.UserInfoEntity;

@Service
public class UserService {
	
	@Autowired
	UserInfoDAO userInfoDAO;

	@Autowired
	ModelMapper modelMapper;
	
	public boolean userRegistration(UserInfoDTO userInfoDTO) {
		UserInfoEntity userInfoEntity = modelMapper.map(userInfoDTO, UserInfoEntity.class);
		UserInfoEntity user = userInfoDAO.insertUserInfo(userInfoEntity);
		return user != null;
	}
	
	public UserInfoEntity userLoginValidation(String emailId,String password)
	{
		return userInfoDAO.userLogin(emailId, password);
	}
	
	public UserInfoEntity getUserById(int userId)
	{
		return userInfoDAO.getUserById(userId);
	}
}
