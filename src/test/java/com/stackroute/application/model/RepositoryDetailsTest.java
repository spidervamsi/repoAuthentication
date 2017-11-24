package com.stackroute.application.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class RepositoryDetailsTest {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@Test
	public void testUrl() {
		RepositoryDetails repositorydetails = new RepositoryDetails();
		
		repositorydetails.setUrl("www.github.com");
		String actual = repositorydetails.getUrl();
		
		assertNotNull(actual);
		assertEquals("www.github", actual);
	}
	
	
	@Test
	public void testFolderPath() {
		RepositoryDetails repositorydetails = new RepositoryDetails();
		
		repositorydetails.setUrl("/home");
		String actual = repositorydetails.getUrl();
		
		assertNotNull(actual);
		assertEquals("/home", actual);
	}
	
	

}
