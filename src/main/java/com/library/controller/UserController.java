package com.library.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.library.dto.UserCartInfoDTO;
import com.library.dto.UserInfoDTO;
import com.library.entity.UserInfoEntity;
import com.library.service.BookService;
import com.library.service.UserCartService;
import com.library.service.UserService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@Autowired
	UserCartService userCartService;

	@RequestMapping("/homepage")
	public String homePage() {
		return "Homepage";
	}

	@RequestMapping("/userregistrationpage")
	public String userRegistration() {
		return "UserRegistration";
	}

	@RequestMapping("/userregistrationrequest")
	public String userRegistrationRequest(@Valid UserInfoDTO userInfoDTO, Model model) {
		model.addAttribute("registrationstatus",
				userService.userRegistration(userInfoDTO) ? "Registration Success" : "Registration Failed");
		return "UserRegistration";
	}

	@RequestMapping("/userloginpage")
	public String userLoginPage() {
		return "UserLogin";
	}

	@RequestMapping("/userloginrequest")
	public String userLoginValidation(String emailId, String password, Model model) {
		UserInfoEntity userInfoEntity = userService.userLoginValidation(emailId, password);
		if (userInfoEntity != null) {
			model.addAttribute("loginstatus", userService.userLoginValidation(emailId, password).getFirstName());
			model.addAttribute("allBookDetails", bookService.getAllBookDetails());
			model.addAttribute("username", userInfoEntity.getFirstName().toUpperCase());
			model.addAttribute("userId", userInfoEntity.getUserId());
			model.addAttribute("cartcount", userCartService.getCountOfUserCart(userInfoEntity.getUserId()));
			return "AllBookDetailsUser";
		}
		model.addAttribute("loginstatus", "Login Failed");
		return "UserLogin";
	}

	@RequestMapping("/addtocart")
	public String addToCart(UserCartInfoDTO userCartInfoDTO, Model model) {
		if (userCartService.addBookToCart(userCartInfoDTO)) {
			model.addAttribute("allBookDetails", bookService.getAllBookDetails());
			model.addAttribute("cartcount", userCartService.getCountOfUserCart(userCartInfoDTO.getUserId()));
			model.addAttribute("username",
					userService.getUserById(userCartInfoDTO.getUserId()).getFirstName().toUpperCase());
			model.addAttribute("userId", userCartInfoDTO.getUserId());
			model.addAttribute("addBookToCartStatus", "Book Added");
			return "AllBookDetailsUser";
		} else {
			model.addAttribute("allBookDetails", bookService.getAllBookDetails());
			model.addAttribute("cartcount", userCartService.getCountOfUserCart(userCartInfoDTO.getUserId()));
			model.addAttribute("username",
					userService.getUserById(userCartInfoDTO.getUserId()).getFirstName().toUpperCase());
			model.addAttribute("userId", userCartInfoDTO.getUserId());
			model.addAttribute("addBookToCartStatus", "Book Is Already In Cart");
			return "AllBookDetailsUser";
		}
	}
	
	@RequestMapping("/cartpage")
	public String userCartPageRequest(int userId,Model model)
	{
		if(!userCartService.getBooksInUserCart(userId).isEmpty())
		{
			model.addAttribute("allbookdetails", userCartService.getBooksInUserCart(userId));
			model.addAttribute("userId", userId);
			model.addAttribute("totalprice", userCartService.getTotalPriceOfBooksInCart(userId));
			return "UserCartPage";
		}
		model.addAttribute("emptycartmsg", "No Books In Cart");
		model.addAttribute("userId", userId);
		return "UserCartPage";
	}
	
	
	@RequestMapping("/allbookdetails")
	public String allBookDetails(int userId, Model model) {
	    model.addAttribute("allBookDetails", bookService.getAllBookDetails());
	    model.addAttribute("username", userService.getUserById(userId).getFirstName().toUpperCase());
	    model.addAttribute("userId", userId);
	    model.addAttribute("cartcount", userCartService.getCountOfUserCart(userId));
	    return "AllBookDetailsUser";
	}

	@RequestMapping("/deletebookincart")
	public String deleteBookInCart(int bookId,int userId)
	{
		userCartService.deleteByBookIdAndUserId(bookId, userId);
		return "redirect:/cartpage?userId=" + userId;
	}
	
	@RequestMapping("/buyrequest")
	public String buyRequest(Model model)
	{
		model.addAttribute("buymsg", "Order Placed Successfully");
		return "UserBuyPage";
	}
	
	@RequestMapping("/buypage")
	public String buyBooksRequest(int userId, Model model) {
	    double totalAmount = userCartService.getTotalPriceOfBooksInCart(userId);
	    model.addAttribute("userId", userId);
	    model.addAttribute("totalAmount", totalAmount);
	    return "CashfreePaymentPage"; 
	}

}
