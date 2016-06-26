package com.albertogaona.centi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.albertogaona.centi.bean.UserInfo;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public UserInfo getUserByUsername(String username) {
		String stmt = 
				 "SELECT u.id, u.password, a.authority role "
				+ "FROM the_user u JOIN authority a ON (u.id = a.user_id) "
				+ "WHERE u.enabled = TRUE "
				+ "AND u.username = ?"
					;
		UserInfo userInfo = (UserInfo)jdbcTemplate
				.queryForObject(stmt, new Object[] { username }, new RowMapper<UserInfo>() {

					@Override
					public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserInfo userInfo = new UserInfo();
						userInfo.setUsername(username);
						userInfo.setPassword(rs.getString("password"));
						userInfo.setRole(rs.getString("role"));
						return userInfo;
					}
					
				});
		return userInfo;
	}

}
