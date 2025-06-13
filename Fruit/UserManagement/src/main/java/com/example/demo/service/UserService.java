package com.example.demo.service;

import com.example.demo.jwt.JwtUtil;
import com.example.demo.model.UserDetails;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.model.response.SignUpResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.sto.UserDTO;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    
    public UserService(UserRepository userRepository,JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    @Override
    public SignUpResponse SignIn(UserDetails userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        SignUpResponse response = new SignUpResponse();

        UserDetails savedUser = userRepository.save(userDetails);

        if (savedUser != null && savedUser.getId() != null) {
            response.setMessage("Signup success");
            response.setStatusCode(200);
        } else {
            response.setMessage("Signup failed");
            response.setStatusCode(400);
        }

        return response;
    }

    
    @Override
    public LoginResponse Login(UserDTO userDto) {
        UserDetails user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        LoginResponse obj=new LoginResponse();
        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            System.out.println("JWT Token: " + token); // or return it in response
            obj.setJwt(token);
            obj.setStatusCode(200);
            obj.setMessage("Logged In");
            
            return obj;
        }else {
        	obj.setJwt("");
            obj.setStatusCode(400);
            obj.setMessage("Invalid credentials");
            return obj;
        }
    }
    
    @Override
	public List<UserDetails>GetUsers(){
		return userRepository.GetUsers();
	}


}
