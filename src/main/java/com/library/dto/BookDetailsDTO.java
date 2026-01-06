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
	@NotBlank(message = "Invalid Author Name")
	private String bookCategory;
	@NotBlank(message = "Invalid Author Name")
	private String bookLanguage;
	@Min(value = 50, message = "pages should be >30")
	@Max(value = 1000, message = "price should be <1000")
	private int bookPages;
	@Min(value = 100, message = "price should be >100")
	@Max(value = 5000, message = "price should be <5000")
	private int bookPrice;
}
