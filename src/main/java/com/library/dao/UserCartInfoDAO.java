package com.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.UserCartInfoEntity;
import com.library.repository.UserCartRepository;

@Repository
public class UserCartInfoDAO {

	@Autowired
	UserCartRepository userCartRepo;

	public boolean addBookToCart(UserCartInfoEntity userCartInfoEntity) {
	    if (!userCartRepo.existsByUserIdAndBookId(userCartInfoEntity.getUserId(), userCartInfoEntity.getBookId())) {
	        userCartRepo.save(userCartInfoEntity);
	        return true;
	    }
	    return false; 
	}


	public int getCountOfUserCart(int userId) {
		return userCartRepo.countByUserId(userId);
	}
	
	public List<UserCartInfoEntity> getCartDetailsByUserId(int userId)
	{
		return userCartRepo.findByUserId(userId);
	}
	
	public void deleteByBookIdAndUserId(int bookId, int userId)
	{
		userCartRepo.deleteByBookIdAndUserId(bookId, userId);
	}

}
