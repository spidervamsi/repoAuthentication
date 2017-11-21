package com.stackroute.application.service;

import java.util.List;

import com.stackroute.application.model.UserCredentials;

public interface DatabaseService {
	List<UserCredentials> read();
}
