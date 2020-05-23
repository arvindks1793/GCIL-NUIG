package com.gcil.cms.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ServiceTypeRowMapper implements RowMapper<RequestAndCsutomer> {

	@Override
	public RequestAndCsutomer mapRow(ResultSet rs, int rowNum) throws SQLException {

		RequestAndCsutomer request = new RequestAndCsutomer();
		request.setServiceTypeId(rs.getString("SERVICE_TYPE_ID"));
		return request;
	}

}
