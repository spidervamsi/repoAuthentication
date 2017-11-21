package com.stackroute.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.application.model.UserCredentials;
import com.stackroute.application.repository.UserCredentialsCRUDRepository;

@Service
public class MongoDbDatabaseServiceImpl implements DatabaseService {
	@Autowired
	private UserCredentialsCRUDRepository repoObject;
	
	@Override
	public List<UserCredentials> read() {
		List<UserCredentials> usercredentialsList = (List<UserCredentials>) repoObject.findAll();
		return usercredentialsList;
	}

}
