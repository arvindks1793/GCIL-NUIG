package com.gcil.cms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.exception.UserNotFoundException;
import com.gcil.cms.app.model.Login;
import com.gcil.cms.app.service.GcilCmsLoginService;

@RestController
public class GcilCmsLoginController {

	@Autowired
	private GcilCmsLoginService loginService;

	// private static final Logger logger =
	// LoggerFactory.getLogger(GcilCmsLoginController.class);

	@RequestMapping(value = "/gcil/user/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> userLogin(@RequestBody Login login)
			throws UserNotFoundException, GcilServiceException {

		Login userCredentials;
		boolean isUserValid = false;
		String employeeId = login.getEmployeeId();

		boolean isEmployeeExists = loginService.isEmployeeExists(employeeId);
		if (isEmployeeExists) {
			userCredentials = loginService.getUserCredentials(login);
			if (userCredentials == null) {
				throw new UserNotFoundException("Invalid username" + " " + login.getUserName());
			}
			String username = login.getUserName();
			String passowrd = login.getPassword();
			if (username != null && !username.isEmpty() && username != "") {
				if (username.equals(userCredentials.getUserName().toString())) {
					if (passowrd.equals(userCredentials.getPassword().toString())) {
						isUserValid = true;
					} else {
						return new ResponseEntity<Boolean>(isUserValid, HttpStatus.UNAUTHORIZED);
					}
				} else {
					throw new UserNotFoundException("Invalid username" + " " + username);
				}
			}

		} else {

			throw new UserNotFoundException("Invalid employeeId" + " " + employeeId);
		}

		return new ResponseEntity<Boolean>(isUserValid, HttpStatus.OK);
	}
}
