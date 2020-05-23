package com.gcil.cms.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcil.cms.app.exception.GcilServiceException;
import com.gcil.cms.app.exception.RequestNotFoundException;
import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.service.GcilCmsSearchRequestService;

@Controller
public class GcilCmsSearchRequestController {

	@Autowired
	GcilCmsSearchRequestService searchRequestService;

	@RequestMapping(value = "/gcil/searchRequest", method = RequestMethod.GET)
	public ResponseEntity<List<RequestAndCsutomer>> searchRequest(@RequestParam Map searchMap)
			throws GcilServiceException, RequestNotFoundException {

		List<RequestAndCsutomer> requestList = new ArrayList<RequestAndCsutomer>();
		
		if (!searchMap.isEmpty()) {
			requestList = searchRequestService.searchRequest(searchMap);
		}

		if (requestList.isEmpty()) {
			throw new RequestNotFoundException("No requests found with given data");
		}
		return new ResponseEntity<List<RequestAndCsutomer>>(requestList, HttpStatus.OK);
	}

}
