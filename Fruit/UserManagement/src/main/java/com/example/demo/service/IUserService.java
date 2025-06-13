package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserDetails;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.model.response.SignUpResponse;
import com.example.demo.sto.UserDTO;

public interface IUserService {
	public SignUpResponse SignIn(UserDetails userdetails);
	public LoginResponse Login(UserDTO usedto);
	public List<UserDetails>GetUsers();

}
