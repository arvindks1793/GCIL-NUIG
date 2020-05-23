package com.gcil.cms.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcil.cms.app.dao.GcilCmsFindRequestDAO;
import com.gcil.cms.app.model.RequestAndCsutomer;

@Service
public class GcilCmsFindRequestService {
	
	@Autowired 
	GcilCmsFindRequestDAO requestdao;

	public List<RequestAndCsutomer> findRequestByPhoneNumber(String phoneNumber) {

      List<RequestAndCsutomer> requestList = new ArrayList<RequestAndCsutomer>();
      
      requestList = requestdao.findRequestByPhoneNumber(phoneNumber);
		
		return requestList;
	}

}
