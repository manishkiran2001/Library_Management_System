package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.library.dto.BookDetailsDTO;
import com.library.entity.AdminInfoEntity;
import com.library.service.AdminService;
import com.library.service.BookService;
import jakarta.validation.Valid;

@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	BookService bookService;

	@RequestMapping("/adminloginpage")
	public String adminLoginPage() {
		return "AdminLogin";
	}

	@RequestMapping("/adminloginvalidation")
	public String adminLoginRequest(String emailId, String password, Model model) {
		AdminInfoEntity adminInfoEntity = adminService.validateAdminByEmailIdAndPassword(emailId, password);
		if (adminInfoEntity != null) {
			model.addAttribute("loginmsg", adminInfoEntity.getName().toUpperCase());
			return "BookDetails";
		}
		model.addAttribute("loginmsg", "Login Failed");
		return "AdminLogin";
	}

	@RequestMapping("/bookregistrationpage")
	public String bookRegistration() {
		return "BookDetails";
	}

	@RequestMapping("/insertbookdetails")
	public String insertBookDetails(@Valid BookDetailsDTO bookDetailsDTO, Model model,String adminName) {
		if (bookService.insertBookDetails(bookDetailsDTO)) {
			model.addAttribute("status", "Book Added");
		} else {
			model.addAttribute("status", "Book is Not Added");
		}
		model.addAttribute("loginmsg", adminName);
		return "BookDetails";
	}
	
	@RequestMapping("displayallbookdetails")
	public String displayAllBooks(Model model,String adminName) {
		model.addAttribute("allBookDetails", bookService.getAllBookDetails());
		model.addAttribute("loginmsg", adminName);
		return "AllBookDetails";
	}

	@RequestMapping("/deletebook")
	public String deleteBookById(int bookId) {
		bookService.deleteBook(bookId);
		return "redirect:/displayallbookdetails";
	}
}
