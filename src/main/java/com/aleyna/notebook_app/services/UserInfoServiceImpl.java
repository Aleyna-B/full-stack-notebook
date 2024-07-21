package com.aleyna.notebook_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleyna.notebook_app.models.UserModel;
import com.aleyna.notebook_app.repositories.IUserInfoRepository;

@Service
public class UserInfoServiceImpl /*implements IUserModelService*/{

	@Autowired
	private IUserInfoRepository userInfoRepo;
	
	
//	public UserInfoServiceImpl(IUserInfoRepository userInfoRepo) {
//		super();
//		this.userInfoRepo = userInfoRepo;
//	}

	public UserModel addUser(UserModel usermodel) {
		usermodel.setCreationTime();
		usermodel.setUserPassword("{noop}"+usermodel.getUserPassword());
  		return userInfoRepo.save(usermodel);
	}
	
	

}
