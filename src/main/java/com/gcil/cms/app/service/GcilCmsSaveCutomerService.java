package com.gcil.cms.app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcil.cms.app.dao.GcilCmsSaveCustomerDAO;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.model.RequestAndCsutomer;

@Service
public class GcilCmsSaveCutomerService {

	@Autowired
	GcilCmsSaveCustomerDAO saveCustomerDAO;

	public Boolean saveRequest(RequestAndCsutomer reqCustomer) throws GcilServiceException {

		Boolean request = false;
		try {
			request = saveCustomerDAO.saveRequest(reqCustomer);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new GcilServiceException("Error during database transaction");
		}
		return request;
	}

	public Boolean saveCustomerAndRequest(RequestAndCsutomer reqCustomer) throws GcilServiceException {

		Boolean custAndReq = false;
		try {
			custAndReq = saveCustomerDAO.saveCustAndRequest(reqCustomer);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new GcilServiceException("Error during database transaction");
		}
		return custAndReq;
	}

	public Boolean isCustomerExists(RequestAndCsutomer requestAndCust) {
		Boolean custAndReq = false;
		Boolean isCusomerExist = saveCustomerDAO.isCustomerExist(requestAndCust);
		if (isCusomerExist) {
			custAndReq = true;
		} else {
			custAndReq = false;
		}
		return custAndReq;
	}

}
