package com.library.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookDetailsDAO;
import com.library.dto.BookDetailsDTO;
import com.library.entity.BookDetailsEntity;

@Service
public class BookService {

	@Autowired
	BookDetailsDAO bookDetailsDAO;

	@Autowired
	ModelMapper modelMapper;

	public boolean insertBookDetails(BookDetailsDTO bookDetailsDTO) {
		BookDetailsEntity bookDetailsEntity = modelMapper.map(bookDetailsDTO, BookDetailsEntity.class);
		return bookDetailsDAO.insertBookDetails(bookDetailsEntity) != null;
	}

	public List<BookDetailsEntity> getAllBookDetails() {
		return bookDetailsDAO.getAllBookDetails();
	}

	public void deleteBook(int id) {
		bookDetailsDAO.deleteBook(id);
	}

	public BookDetailsEntity getBookById(int id) {
		return bookDetailsDAO.getBookById(id);
	}
}
