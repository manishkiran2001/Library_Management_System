package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.UserCartInfoDAO;
import com.library.dto.UserCartInfoDTO;
import com.library.entity.BookDetailsEntity;
import com.library.entity.UserCartInfoEntity;
import com.library.repository.BookDetailsRepository;

import jakarta.transaction.Transactional;

@Service
public class UserCartService {

	@Autowired
	UserCartInfoDAO userCartInfoDAO;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BookDetailsRepository bookDetailsRepository;
	
	public boolean addBookToCart(UserCartInfoDTO userCartInfoDTO)
	{
		return userCartInfoDAO.addBookToCart(modelMapper.map(userCartInfoDTO, UserCartInfoEntity.class));
	}
	
	public int getCountOfUserCart(int userId) {
		return userCartInfoDAO.getCountOfUserCart(userId);
	}
	
	public List<BookDetailsEntity> getBooksInUserCart(int userId)
	{
		List<Integer> bookIds=new ArrayList<Integer>();
		for(UserCartInfoEntity UserCartInfoEntity:userCartInfoDAO.getCartDetailsByUserId(userId))
		{
			bookIds.add(UserCartInfoEntity.getBookId());
		}
		return bookDetailsRepository.findByBookIdIn(bookIds);
	}
	
	@Transactional
	public void deleteByBookIdAndUserId(int bookId, int userId)
	{
		userCartInfoDAO.deleteByBookIdAndUserId(bookId, userId);
	}

	@Transactional
	public void clearCartByUserId(int userId)
	{
		userCartInfoDAO.clearCartByUserId(userId);
	}
	
	public int getTotalPriceOfBooksInCart(int userId)
	{
		int totalPrice=0;
		for(BookDetailsEntity book:getBooksInUserCart(userId)) {
			totalPrice+=book.getBookPrice();
		}
		return totalPrice;
	}
}
