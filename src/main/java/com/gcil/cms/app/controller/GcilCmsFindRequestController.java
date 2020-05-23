package com.gcil.cms.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.service.GcilCmsFindRequestService;

@Controller
public class GcilCmsFindRequestController {

	@Autowired
	GcilCmsFindRequestService requestSrvice;
	
	@RequestMapping(value = "/gcil/requestSearch/{phoneNumber}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RequestAndCsutomer>>findRequestByPhoneNumber(@PathVariable String phoneNumber){
		
		List<RequestAndCsutomer> requestList = new ArrayList<RequestAndCsutomer>();
		
		requestList = requestSrvice.findRequestByPhoneNumber(phoneNumber);
		
		return new ResponseEntity<List<RequestAndCsutomer>>(requestList,HttpStatus.OK);
		
	}

}
