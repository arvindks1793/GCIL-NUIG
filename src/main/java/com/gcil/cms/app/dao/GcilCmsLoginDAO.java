package com.gcil.cms.app.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcil.cms.app.model.Login;
import com.gcil.cms.app.model.LoginRowMapper;

@Transactional
@Repository
public class GcilCmsLoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Login getUserCredentials(Login login) throws SQLException {

		String userName = login.getUserName();
		String Sql = "SELECT PASSOWRD,USERNAME FROM USER_LOGIN WHERE USERNAME = ? ";
		RowMapper<Login> rowMapper = new LoginRowMapper();
		Login userCredentials = jdbcTemplate.queryForObject(Sql, rowMapper, userName);
		return userCredentials;
	}

	public int validateUser(String userName) {

		String Sql = "SELECT COUNT(*) FROM USER_LOGIN WHERE USERNAME = ?";
		int count = jdbcTemplate.queryForObject(Sql, new Object[] { userName }, Integer.class);
		return count;
	}

	public boolean isEmployeeExists(String employeeId) {
		String Sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		int count = jdbcTemplate.queryForObject(Sql, new Object[] { employeeId }, Integer.class);
		if (count > 0) {
			return true;
		}
		return false;
	}

}
