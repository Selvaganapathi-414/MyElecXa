package com.elecxa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elecxa.model.User;
import com.elecxa.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@CrossOrigin("*")
public class AuthController {

	@Autowired
	UserService userService;

	@GetMapping("/auth/login/{credential}")
	public ResponseEntity<?> isUserExists(@PathVariable String credential) {
	    try {

	    	User user = userService.getUserByEmail(credential);
	        return ResponseEntity.ok(user);
	    } catch (EntityNotFoundException exByEmail) {
	        try {

	        	User user = userService.getUserByPhoneNumber(credential);
	            return ResponseEntity.ok(user);
	            
	        } catch (EntityNotFoundException exByPhone) {

	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                                 .body("User not found with provided email or phone number: " + credential);
	        }
	    }
	}
	
	
	@GetMapping("/auth/password/{credential}/{passwordInput}")
	public ResponseEntity<?> isValidPassword(@PathVariable String credential , @PathVariable String passwordInput) {
	    try {

	    	User user = userService.getUserByEmail(credential);
	    	
	    	if(user.getPassword().equals(passwordInput)) {
		        return ResponseEntity.ok(user);
	    	}
	    	else {
	    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Password doesn't match");
	    	}
	    } 
	    catch (EntityNotFoundException exByEmail) {
	        	User user = userService.getUserByPhoneNumber(credential);
	        	System.out.println(user.getPassword());
	        	if(user.getPassword().equals(passwordInput)) {
			        return ResponseEntity.ok(user);
		    	}
		    	else {
		    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                        .body("Password doesn't match");
		    	}
	            
	        }
	    }


}
