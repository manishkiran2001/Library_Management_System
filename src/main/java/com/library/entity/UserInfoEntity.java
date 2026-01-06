package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false)
	private String firstName;
	private String lastName;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false,unique = true)
	private String emailId;
	@Column(nullable = false,unique = true)
	private long mobileNumber;
	@Column(nullable = false)
	private String password;
	private String address;
}
