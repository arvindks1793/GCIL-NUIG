package com.gcil.cms.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;


public class LoginRowMapper implements RowMapper<Login> {
	private static final Logger logger = LoggerFactory.getLogger(LoginRowMapper.class);
	@Override
	public Login mapRow(ResultSet row, int rowNum) throws SQLException {
		Login loginModel = null;
		try {
			System.out.println("inside row mapper");
			loginModel = new Login();
			loginModel.setPassword(row.getString("PASSOWRD"));	
			loginModel.setUserName(row.getString("USERNAME"));
			System.out.println("exiting row mapper");
		}catch(SQLException sqlEx) {
			logger.debug(sqlEx.getMessage());
			
		}catch(Exception ex) {
			
			logger.debug(ex.getMessage());
		}
		return loginModel;
	}

}
