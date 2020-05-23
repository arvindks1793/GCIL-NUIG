package com.gcil.cms.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcil.cms.app.dao.GcilCmsLoginDAO;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.exception.UserNotFoundException;
import com.gcil.cms.app.model.Login;

@Service
public class GcilCmsLoginService {

	private static final Logger logger = LoggerFactory.getLogger(GcilCmsLoginService.class);

	@Autowired
	private GcilCmsLoginDAO loginDAO;

	public Login getUserCredentials(Login login) throws GcilServiceException {

		Login userCredentials = null;
		int userCount;
		try {
			userCount = loginDAO.validateUser(login.getUserName());
			if (userCount > 0) {
				userCredentials = loginDAO.getUserCredentials(login);
				System.out.println(userCredentials.getPassword() + "=========" + userCredentials.getUserName());
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getClass());
			throw new GcilServiceException("Error during database transaction");
		}
		return userCredentials;
	}

	public boolean isEmployeeExists(String employeeId) {
		
		boolean isEmployeeExists = loginDAO.isEmployeeExists(employeeId);
		
		return isEmployeeExists;
	}

}
