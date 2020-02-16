package com.gcil.cms.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gcil.cms.app.service.GcilCmsLoginService;

@RestController
public class GcilCmsLoginController {
	
	@Autowired
	private GcilCmsLoginService loginService;
	
	private static final Logger logger =  LoggerFactory.getLogger(GcilCmsLoginController.class);

}
