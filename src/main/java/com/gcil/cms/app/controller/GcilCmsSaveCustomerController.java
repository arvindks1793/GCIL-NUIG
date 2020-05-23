package com.gcil.cms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcil.cms.app.exception.CustomerExistsException;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.service.GcilCmsSaveCutomerService;

@RestController
public class GcilCmsSaveCustomerController {

	@Autowired
	GcilCmsSaveCutomerService saveCustomerService;

	private static final String CUST_TYPE_OLD = "old";
	private static final String REQUEST_SUCCESS_MESSAGE = "Request saved successfully!";
	private static final String REQUEST_FAILURE_MESSAGE = "Could not save request";
	private static final String CUSTOMER_SUCCESS_MESSAGE = "Customer and request saved sucessfully";
	private static final String CUSTOMER_FAILURE_MESSAGE = "Could not save new customer!";
	private static final String CUSTOMER_EXISTS_EXCEPTION = "Customer already exists with phone number  ";

	@RequestMapping(value = "/gcil/saveCustomerRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCustomerRequest(@RequestBody RequestAndCsutomer requestAndCust)
			throws GcilServiceException, CustomerExistsException, Exception {

		if (requestAndCust.getCustomerType().equals(CUST_TYPE_OLD)) {
			Boolean saveRequest = saveCustomerService.saveRequest(requestAndCust);
			if (saveRequest) {
				return new ResponseEntity<String>(REQUEST_SUCCESS_MESSAGE, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>(REQUEST_FAILURE_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			Boolean saveCustomerAndRequest = false;
			Boolean isCustomerExists = saveCustomerService.isCustomerExists(requestAndCust);
			if (isCustomerExists) {
				throw new CustomerExistsException(CUSTOMER_EXISTS_EXCEPTION + requestAndCust.getMobileNumber());
			} else {
				saveCustomerAndRequest = saveCustomerService.saveCustomerAndRequest(requestAndCust);
			}
			if (saveCustomerAndRequest) {
				return new ResponseEntity<String>(CUSTOMER_SUCCESS_MESSAGE, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>(CUSTOMER_FAILURE_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

}
