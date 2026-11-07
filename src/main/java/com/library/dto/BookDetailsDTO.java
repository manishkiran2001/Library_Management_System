package com.library.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDetailsDTO {

	private int bookId;
	@NotBlank(message = "Invalid Book Title")
	private String bookTitle;
	@NotBlank(message = "Invalid Author Name")
	private String bookAuthor;
	@NotBlank(message = "Invalid Category")
	private String bookCategory;
	@NotBlank(message = "Invalid Language")
	private String bookLanguage;
	@Min(value = 50, message = "Pages should be at least 50")
	@Max(value = 1000, message = "Pages should not exceed 1000")
	private int bookPages;
	@Min(value = 100, message = "Price should be at least 100")
	@Max(value = 5000, message = "Price should not exceed 5000")
	private int bookPrice;
}
