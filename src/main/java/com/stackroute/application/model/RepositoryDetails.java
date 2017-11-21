/*
this file should contain your microservice data model
*/

package com.stackroute.application.model;

import javax.validation.constraints.NotNull;

/*
javax.validation.constraints must be present in your data model
check link: https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html 
TODO: needed
*/
public class RepositoryDetails {
	@NotNull(message="repository url cannot be null")
	private String url;
	
	@NotNull(message="folderpath cannot be null")
    private String folderpath;
	
    public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getFolderpath() {
		return folderpath;
	}
	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
	}   
}
