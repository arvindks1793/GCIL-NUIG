package com.gcil.cms.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RequestRowMapper implements RowMapper<RequestAndCsutomer> {

	@Override
	public RequestAndCsutomer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RequestAndCsutomer request = new RequestAndCsutomer();
		
		request.setRequestId(rs.getInt("REQUEST_ID"));
		request.setRequestBrief(rs.getString("REQUEST_BRIEF"));
		request.setRequestStatus(rs.getString("REQUEST_STATUS"));
		request.setRequestDateTime(rs.getString("REQUEST_DATETIME"));
		request.setFirstName(rs.getString("FIRST_NAME"));
		request.setServiceTypeName(rs.getString("SERVICE_TYPE_NAME"));
		
		return request;
	}
	
	

}
