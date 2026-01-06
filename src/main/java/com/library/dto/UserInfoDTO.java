package com.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDTO {
	private int userId;
	@NotBlank(message = "Invalid First Name")
	private String firstName;
	@NotBlank(message = "Invalid last Name")
	private String lastName;
	@Email(message = "Invalid Email Id")
	private String emailId;
	@Min(value = 6000000000l,message = "Invalid Mobile Number")
	@Max(value = 9999999999l,message = "Invalid Mobile Number")
	private long mobileNumber;
	@NotBlank(message = "Invalid Password")
	private String password;
	@NotBlank(message = "Invalid Gender")
	private String gender;
	@NotBlank(message = "Invalid Address")
	private String address;
}
