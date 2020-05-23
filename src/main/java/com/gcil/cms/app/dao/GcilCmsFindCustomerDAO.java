package com.gcil.cms.app.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.model.CustomerRowMapper;

@Transactional
@Repository
public class GcilCmsFindCustomerDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public RequestAndCsutomer getCustByPhoneNumber(String phoneNumber) throws SQLException {

		String Sql = "SELECT CUSTOMER_ID, FIRST_NAME,LAST_NAME,MOBILE_NO,CUSTOMER_EMAIL," + " "
				+ " ADDRESS_LINE1, ADDRESS_LINE2,CITY,COUNTY,ZIPCODE,COUNTRY FROM CUSTOMER WHERE" + " "
				+ "MOBILE_NO = ?";
		RowMapper<RequestAndCsutomer> customerRowMapper = new CustomerRowMapper();
		System.out.println("before query execution");
		RequestAndCsutomer customer = jdbcTemplate.queryForObject(Sql, customerRowMapper, phoneNumber);
		return customer;
	}

	public int getCustCount(String phoneNumber) throws SQLException {

		String Sql = "SELECT COUNT(*) FROM CUSTOMER WHERE MOBILE_NO = ?";
		int count = jdbcTemplate.queryForObject(Sql, new Object[] { phoneNumber }, Integer.class);
		return count;

	}

}