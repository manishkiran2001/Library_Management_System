package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCartInfoDTO {

	private int cartId;
	private int userId;
	private int bookId;
	
}
