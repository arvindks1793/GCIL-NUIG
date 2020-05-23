package com.gcil.cms.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.model.RequestRowMapper;

@Transactional
@Repository
public class GcilCmsFindRequestDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<RequestAndCsutomer> findRequestByPhoneNumber(String phoneNumber) {

		String Sql = "SELECT R.REQUEST_ID,R.REQUEST_BRIEF,R.REQUEST_DESC,R.ADDITIONAL_INFO,\r\n"
				+ "R.REQUEST_ACTION,R.REQUEST_STATUS,R.REQUEST_SOURCE,R.REQUEST_DATETIME,\r\n"
				+ "R.EMPLOYEE_ID,C.FIRST_NAME,C.LAST_NAME, S.SERVICE_TYPE_NAME FROM REQUEST R INNER JOIN\r\n"
				+ "CUSTOMER C ON R.CUSTOMER_ID = C.CUSTOMER_ID INNER JOIN\r\n"
				+ "SERVICE_TYPE S ON R.SERVICE_TYPE_ID = S.SERVICE_TYPE_ID\r\n" + "WHERE C.MOBILE_NO = ?";

		List<RequestAndCsutomer> requestList = new ArrayList<RequestAndCsutomer>();
		RowMapper<RequestAndCsutomer> rowMapper = new RequestRowMapper();
		requestList = jdbctemplate.query(Sql, rowMapper, phoneNumber);
		return requestList;

	}

}
