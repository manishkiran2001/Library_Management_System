package com.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.library.entity.BookDetailsEntity;
import com.library.repository.BookDetailsRepository;

@Repository
public class BookDetailsDAO {

	@Autowired
	BookDetailsRepository bookDetailsRepository;
	
	public BookDetailsEntity insertBookDetails(BookDetailsEntity bookDetailsEntity)
	{
		return bookDetailsRepository.save(bookDetailsEntity);
	}
	
	public List<BookDetailsEntity> getAllBookDetails()
	{
		return bookDetailsRepository.findAll();
	}
	
	public void deleteBook(int id)
	{
		bookDetailsRepository.deleteById(id);
	}
}
