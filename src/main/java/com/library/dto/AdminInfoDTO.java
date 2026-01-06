package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminInfoDTO {
	private int id;
	private String name;
	private String emailId;
	private String password;
	
}
