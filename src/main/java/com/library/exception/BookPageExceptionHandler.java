package com.library.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.controller.AdminController;

@ControllerAdvice(assignableTypes = AdminController.class)
public class BookPageExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String bookPageExceptionHandler(MethodArgumentNotValidException ex, Model model) {
		Map<String, String> errors = new HashMap<String, String>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		allErrors.forEach(error -> {
			String field = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			errors.put(field, msg);
		});
		model.addAttribute("allFieldErrors", errors);
		return "BookDetails";
	}
}
