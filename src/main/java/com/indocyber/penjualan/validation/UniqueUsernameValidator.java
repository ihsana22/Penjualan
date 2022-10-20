package com.indocyber.penjualan.validation;

import com.indocyber.penjualan.service.abstraction.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
	
	@Autowired
	private UsersService service;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return !service.checkExistingAccount(username);
	}

}
