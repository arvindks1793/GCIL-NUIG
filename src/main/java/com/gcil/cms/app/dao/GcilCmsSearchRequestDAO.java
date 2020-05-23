package com.gcil.cms.app.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcil.cms.app.model.CustomerRowMapper;
import com.gcil.cms.app.model.RequestAndCsutomer;
import com.gcil.cms.app.model.RequestRowMapper;

@Transactional
@Repository
public class GcilCmsSearchRequestDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<RequestAndCsutomer> searchRequest(Map searchMap) throws SQLException,Exception {

		String requestServiceType = (String) searchMap.get("serviceType");
		String requestStatus = (String) searchMap.get("requestStatus");
		String requestFromDate = (String) searchMap.get("fromDate");
		String requestToDate = (String) searchMap.get("toDate");

		StringBuilder Sql = new StringBuilder(
				"SELECT R.REQUEST_ID,S.SERVICE_TYPE_NAME, C.FIRST_NAME,R.REQUEST_BRIEF,R.REQUEST_STATUS,R.REQUEST_DATETIME\r\n"
						+ "FROM REQUEST R INNER JOIN CUSTOMER C ON R.CUSTOMER_ID = C.CUSTOMER_ID\r\n"
						+ "INNER JOIN SERVICE_TYPE S ON R.SERVICE_TYPE_ID = S.SERVICE_TYPE_ID\r\n" + "WHERE ");

		String customSql = getCustomSql(Sql, searchMap);
		RowMapper<RequestAndCsutomer> requestRowMapper = new RequestRowMapper();
		List<RequestAndCsutomer> requestList = new ArrayList<RequestAndCsutomer>();
		String parameters = "";
		ArrayList<String> queryArgs = new ArrayList<String>();

		if (requestServiceType != null && requestServiceType != "") {
			queryArgs.add(requestServiceType);
		}
		if (requestStatus != null && requestStatus != "") {
			queryArgs.add(requestStatus);
		}

		if (requestFromDate != null && requestFromDate != "") {

			queryArgs.add(requestFromDate);
		}

		if (requestToDate != null && requestToDate != "") {

			queryArgs.add(requestFromDate);
		}

		System.out.println(queryArgs);

		requestList = jdbcTemplate.query(customSql, requestRowMapper, queryArgs.toArray());

		return requestList;
	}

	private String getCustomSql(StringBuilder sql, Map searchMap) throws Exception {

		String requestServiceType = (String) searchMap.get("serviceType");
		String requestStatus = (String) searchMap.get("requestStatus");
		String requestFromDate = (String) searchMap.get("fromDate");
		String requestToDate = (String) searchMap.get("toDate");

		StringBuilder whereClause = new StringBuilder("");
		StringBuilder customQuery = new StringBuilder("");

		if (requestServiceType != null && requestServiceType != "") {
			whereClause = whereClause.append("S.SERVICE_TYPE_NAME = ? ");
		}

		if (requestStatus != null && requestStatus != "") {

			if (whereClause.length() != 0 && !whereClause.toString().equals("") && whereClause != null) {
				System.out.println("null check=========" + whereClause.length() + whereClause.toString() + whereClause);
				whereClause = whereClause.append("AND").append(" R.REQUEST_STATUS = ?");
			} else {
				whereClause = whereClause.append(" R.REQUEST_STATUS = ?");
			}

		}

		if ((requestFromDate != null && requestFromDate != "") && (requestToDate != null && requestToDate != "")) {

			if (whereClause.length() != 0 && !whereClause.toString().equals("") && whereClause != null) {
				whereClause = whereClause.append(" AND").append(" DATE(R.REQUEST_DATETIME) BETWEEN ? AND ? ");
			} else {
				whereClause = whereClause.append(" DATE(R.REQUEST_DATETIME) = ?");
			}
		}

		if ((requestFromDate != null && requestFromDate != "") && !(requestToDate != null && requestToDate != "")) {
			if (whereClause.length() != 0 && !whereClause.toString().equals("") && whereClause != null) {
				whereClause = whereClause.append(" AND").append(" DATE(R.REQUEST_DATETIME) = ?");
			} else {
				whereClause = whereClause.append(" DATE(R.REQUEST_DATETIME) = ?");
			}

		}

		customQuery = sql.append(whereClause);

		System.out.println(customQuery);

		return customQuery.toString();

	}

}
