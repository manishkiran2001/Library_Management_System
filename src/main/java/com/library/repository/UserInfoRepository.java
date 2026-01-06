package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
	
	UserInfoEntity findByEmailIdAndPassword(String emailId,String password);
	
	UserInfoEntity findByUserId(int userId);
}
