package com.gcil.cms.app.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcil.cms.app.model.CustomerRowMapper;
import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.model.ServiceTypeRowMapper;

@Transactional
@Repository
public class GcilCmsSaveCustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean saveRequest(RequestAndCsutomer reqCustomer) throws SQLException {

		String requestDateTime;
		String serviceTypeId = getServiceTypeId(reqCustomer.getServiceTypeName());
		String requestBrief = reqCustomer.getRequestBrief();
		int customerId = reqCustomer.getCustomerId();
		String requestStatus = reqCustomer.getRequestStatus();
		String requestSource = reqCustomer.getRequestSource();
		if (reqCustomer.getCustomerType().equals("old")) {
			requestDateTime = reqCustomer.getRequestDateTime();
		} else {
			requestDateTime = reqCustomer.getCustContactDateTime();
		}

		String employeeId = reqCustomer.getReqEmpID();
		String Sql = "INSERT INTO REQUEST (REQUEST_BRIEF,CUSTOMER_ID,SERVICE_TYPE_ID,REQUEST_STATUS,REQUEST_SOURCE,REQUEST_DATETIME,EMPLOYEE_ID)"
				+ " " + "VALUES (?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(Sql, requestBrief, customerId, serviceTypeId, requestStatus, requestSource,
				requestDateTime, employeeId);
		if (count > 0) {
			return true;
		} else {
			return false;
		}

	}

	private String getServiceTypeId(String serviceTypeName) throws SQLException {
		System.out.println("inside service type id fetch method");
		String Sql = "SELECT SERVICE_TYPE_ID FROM SERVICE_TYPE WHERE SERVICE_TYPE_NAME = ?";
		RowMapper<RequestAndCsutomer> serviceTypeRowMapper = new ServiceTypeRowMapper();
		RequestAndCsutomer serviceTypeId = jdbcTemplate.queryForObject(Sql, serviceTypeRowMapper, serviceTypeName);
		return serviceTypeId.getServiceTypeId();
	}

	public Boolean saveCustAndRequest(RequestAndCsutomer reqCustomer) throws SQLException {

		String firstName = reqCustomer.getFirstName();
		String lastName = reqCustomer.getLastName();
		String mobileNo = reqCustomer.getMobileNumber();
		String customerEmail = reqCustomer.getEmailId();
		String addressLine1 = reqCustomer.getAddressLineOne();
		String addressLine2 = reqCustomer.getAddressLineTwo();
		String City = reqCustomer.getCity();
		String County = reqCustomer.getCounty();
		String Zipcode = reqCustomer.getZipCode();
		String Country = reqCustomer.getCountry();
		String custContactDateTime = reqCustomer.getCustContactDateTime();

		String Sql = "INSERT INTO CUSTOMER (FIRST_NAME,LAST_NAME,MOBILE_NO,CUSTOMER_EMAIL,ADDRESS_LINE1,"
				+ "ADDRESS_LINE2,CITY,COUNTY,ZIPCODE,COUNTRY,CONTACT_DATETIME) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		int count = jdbcTemplate.update(Sql, firstName, lastName, mobileNo, customerEmail, addressLine1, addressLine2,
				City, County, Zipcode, Country, custContactDateTime);

		if (count > 0) {
			int custId = getCustIdbyMobileNo(mobileNo);
			reqCustomer.setCustomerId(custId);
			Boolean isResquestSaved = saveRequest(reqCustomer);
			if (isResquestSaved) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private int getCustIdbyMobileNo(String mobileNo) throws SQLException {
		String Sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE MOBILE_NO = ?";
		int customerId = jdbcTemplate.queryForObject(Sql, Integer.class, mobileNo);
		return customerId;
	}

	public Boolean isCustomerExist(RequestAndCsutomer reqCustomer) {
		System.out.println("inside check customer");
		String custMoile = reqCustomer.getMobileNumber();
		System.out.println("custmobile===================" + custMoile);
		String Sql = "SELECT COUNT(*) FROM CUSTOMER WHERE MOBILE_NO = ?";
		int count = jdbcTemplate.queryForObject(Sql, new Object[] { custMoile }, Integer.class);
		System.out.println("count========" + count);
		if (count > 0) {
			System.out.println("inside true===============");
			return true;
		}
		return false;
	}

}
