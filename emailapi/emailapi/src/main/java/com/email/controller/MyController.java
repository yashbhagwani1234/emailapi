package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

@RestController
public class MyController {
    @Autowired  
	private EmailService emailservice;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		
		return "hi what's up bro";
	}
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		boolean m = emailservice.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
		System.out.println(request);
	    if(m)
	    {
	    	return ResponseEntity.ok("email send sucessfully");
	    }
	    else {
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent...");
	    }
	}
}
