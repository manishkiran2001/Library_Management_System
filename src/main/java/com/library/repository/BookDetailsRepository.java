package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.BookDetailsEntity;

import java.util.List;

public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, Integer>{

	List<BookDetailsEntity> findByBookIdIn(List<Integer> bookIds);
}
