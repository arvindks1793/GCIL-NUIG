package com.gcil.cms.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcil.cms.app.dao.GcilCmsSearchRequestDAO;
import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.model.RequestAndCsutomer;

@Service
public class GcilCmsSearchRequestService {

	@Autowired
	GcilCmsSearchRequestDAO searchRequestDAO;

	public List<RequestAndCsutomer> searchRequest(Map searchMap) throws GcilServiceException {
		List<RequestAndCsutomer> requestList = null;

		try {
			requestList = new ArrayList<RequestAndCsutomer>();
			requestList = searchRequestDAO.searchRequest(searchMap);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new GcilServiceException("Error during database transaction");
		}
		return requestList;
	}

}
