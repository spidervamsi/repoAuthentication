package com.stackroute.application.service;

import java.io.File;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.stackroute.application.exception.InternalRepositoryException;
import com.stackroute.application.exception.UrlNotRepositoryException;
import com.stackroute.application.model.RepositoryDetails;

@Service
public class SvnRepositoryServiceImpl implements RepositoryService {
	/*
	checking out a repository to a working directory
	*/
	@SuppressWarnings("deprecation")
	public boolean cloneRepository(RepositoryDetails repositorydetails) throws InternalRepositoryException {
		/*
		create driver to connect to remote repository
		*/
		ISVNOptions myOptions = SVNWCUtil.createDefaultOptions(true);
		SVNClientManager clientManager = SVNClientManager.newInstance(myOptions);
		
		/*
		create subversion update object
		*/
		SVNUpdateClient updateClient = clientManager.getUpdateClient();
		updateClient.setIgnoreExternals( false );
		
		
		try {
			/*
			do the checkout
			*/
			updateClient.doCheckout(SVNURL.parseURIEncoded(repositorydetails.getUrl()) , new File(repositorydetails.getFolderpath()), SVNRevision.HEAD, SVNRevision.HEAD, true);
			
			return true;
		} catch (SVNException e) {
			
			throw new InternalRepositoryException("Problem accessing repository");
		}
	
	}

	
	
	
	/*
	check repository url validity
	*/
	@SuppressWarnings("deprecation")
	public boolean checkUrlValidity(String url) throws UrlNotRepositoryException {
		SVNRepository repository = null;
		DAVRepositoryFactory.setup();
		
		
		try {
			 /*
			 creates driver to link to repourl
			 */
			 repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
			 
			 
			 /*
			 if connection done then return true else it throws exception that is caught
			 */
			 repository.testConnection();
			 
		     return true;
		 } catch (SVNException e){
		     throw new UrlNotRepositoryException("This url does not point to a repository.");
		 }
	}
	
	
	
	
	/*
	check local working directory folder validity
	*/
	public boolean checkPathValidity(String folderpath) {
		File dir = new File(folderpath);
		
        // Tests whether the directory denoted by this abstract pathname exists.
		boolean exists = dir.exists();
		
		return exists;
	}
}
