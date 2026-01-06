package com.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BookDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@Column(nullable = false,unique = true)
	private String bookTitle;
	@Column(nullable = false)
	private String bookAuthor;
	@Column(nullable = false)
	private String bookCategory;
	@Column(nullable = false)
	private String bookLanguage;
	@Column(nullable = false)
	private int bookPages;
	@Column(nullable = false)
	private int bookPrice;

}
