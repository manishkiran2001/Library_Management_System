package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.AdminInfoEntity;

public interface AdminInfoRepository extends JpaRepository<AdminInfoEntity, Integer>{
	 AdminInfoEntity findByEmailIdAndPassword(String emailId,String password);
}
