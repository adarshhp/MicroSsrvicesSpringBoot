package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.model.response.SignUpResponse;
import com.example.demo.service.IUserService;
import com.example.demo.sto.UserDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private  IUserService service;
	

	@PostMapping("/signup")
	public SignUpResponse SignIn(@RequestBody UserDetails userdetails) {
		return service.SignIn(userdetails);
	}
	
	@PostMapping("/login")
	public LoginResponse Login(@RequestBody UserDTO usedto) {
		return service.Login(usedto);
	}
	
	@GetMapping("/getusers")
	public List<UserDetails>GetUsers(){
		return service.GetUsers();
	}
	
//	@PostMapping("/logout")
//	public  SignUpResponse String java.lang.String LogOut() {
//		return "ivfhi";
//	}
}
