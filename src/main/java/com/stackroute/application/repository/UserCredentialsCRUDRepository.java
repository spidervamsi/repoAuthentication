package com.stackroute.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.application.model.UserCredentials;

public interface UserCredentialsCRUDRepository extends CrudRepository<UserCredentials, String> {

}
