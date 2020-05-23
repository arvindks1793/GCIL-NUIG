package com.gcil.cms.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<RequestAndCsutomer> {

	@Override
	public RequestAndCsutomer mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("inside row maper");
		
		RequestAndCsutomer customer = new RequestAndCsutomer();
		customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
		customer.setFirstName(rs.getString("FIRST_NAME"));
		customer.setLastName(rs.getString("LAST_NAME"));
		customer.setMobileNumber(rs.getString("MOBILE_NO"));
		customer.setEmailId(rs.getString("CUSTOMER_EMAIL"));
		customer.setAddressLineOne(rs.getString("ADDRESS_LINE1"));
		customer.setAddressLineTwo(rs.getString("ADDRESS_LINE2"));
		customer.setCity(rs.getString("CITY"));
		customer.setCounty(rs.getString("COUNTY"));
		customer.setZipCode(rs.getString("ZIPCODE"));
		customer.setCountry(rs.getString("COUNTRY"));
		
		System.out.println("rowmapper out");

		return customer;
	}

}
