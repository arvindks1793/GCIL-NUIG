package com.gcil.cms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcil.cms.app.dao.GcilCmsFindCustomerDAO;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.model.RequestAndCsutomer;

@Service
public class GcilCmsFindCustomerService {

	RequestAndCsutomer cust = null;
	@Autowired
	GcilCmsFindCustomerDAO findCustDAO;

	public RequestAndCsutomer getCustByPhoneNumber(String phoneNumber) throws GcilServiceException {

		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			try {
				int custCount = findCustDAO.getCustCount(phoneNumber);
				if (custCount > 0) {
					cust = findCustDAO.getCustByPhoneNumber(phoneNumber);
				} else {
					return null;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				throw new GcilServiceException("Error during database transaction");
			}
		} else {
			throw new GcilServiceException("Invalid Phone number");
		}

		return cust;
	}

}
