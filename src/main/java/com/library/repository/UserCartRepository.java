package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.UserCartInfoEntity;
import java.util.List;


public interface UserCartRepository extends JpaRepository<UserCartInfoEntity, Integer>{
	
	boolean existsByUserIdAndBookId(int userId,int bookId);
	
	int countByUserId(int userId);
	
	 List<UserCartInfoEntity> findByUserId(int userId);
	 
	 void deleteByBookIdAndUserId(int bookId, int userId);

	 void deleteByUserId(int userId);
}
