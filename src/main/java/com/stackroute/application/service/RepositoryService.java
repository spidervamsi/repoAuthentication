package com.stackroute.application.service;

import com.stackroute.application.exception.InternalRepositoryException;
import com.stackroute.application.exception.UrlNotRepositoryException;
import com.stackroute.application.model.RepositoryDetails;

public interface RepositoryService {
	/*
	clone a project from remote repository to local machine
	*/
	public boolean cloneRepository(RepositoryDetails repositorydetails) throws InternalRepositoryException;
	
	
	/*
	check repository url validity
	*/
	public boolean checkUrlValidity(String url) throws UrlNotRepositoryException;
	
	
	/*
	check local working directory folder validity
	*/
	public boolean checkPathValidity(String folderpath);
}
