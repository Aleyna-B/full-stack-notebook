package com.aleyna.notebook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleyna.notebook_app.models.UserModel;
import com.aleyna.notebook_app.services.CustomUserDetailsService;
import com.aleyna.notebook_app.services.UserInfoServiceImpl;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoServiceImpl userInfoService;
	
	@PostMapping("/signUp")
	public boolean userSignIn(@RequestBody UserModel usermodel)
	{
		try {
			userInfoService.addUser(usermodel);
			return true; //"redirect:/login/"
		}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return false;
			}
	}
	
//	private CustomUserDetailsService cusdetails;
//
//	@PostMapping("/login")
//	public String userLogin(@RequestBody UserModel usermodel)
//	{
//		try {
//			cusdetails.loadUserByUsername(usermodel.getUserName());
//			return "abc";
//		}catch(Exception e)
//			{
//				System.out.println(e.getMessage());
//				return "no";
//			}
//	}
}
