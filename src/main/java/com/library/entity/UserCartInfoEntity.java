package com.library.entity;

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
public class UserCartInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int userId;
	private int bookId;

}
