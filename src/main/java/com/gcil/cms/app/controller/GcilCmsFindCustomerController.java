package com.gcil.cms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gcil.cms.app.exception.CustomerNotFoundException;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.service.GcilCmsFindCustomerService;

@RestController
public class GcilCmsFindCustomerController {

	@Autowired
	GcilCmsFindCustomerService findCustService;

	@RequestMapping(value = "gcil/customerSearch/{phoneNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestAndCsutomer> findCustByPhoneNumber(@PathVariable String phoneNumber)
			throws CustomerNotFoundException, GcilServiceException {
		RequestAndCsutomer customer = null;
		if (findCustService != null) {
			customer = findCustService.getCustByPhoneNumber(phoneNumber);
			if (customer == null) {
				throw new CustomerNotFoundException("Customer not registered with phone number" + " " + phoneNumber);
			}
		} else {
			throw new GcilServiceException("Service is down");
		}
		return new ResponseEntity<RequestAndCsutomer>(customer, HttpStatus.OK);
	}

}
