/*
 * Copyright 2016 Alberto Gaona.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.albertogaona.centi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.albertogaona.centi.bean.UserInfo;

/**
 * Fetches user information from MySQL database.
 * @author Alberto Gaona
 */
@Repository
public class UserDao {
	
	/**
	 * The JdbcTemplate
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Gets user along with role.
	 * @param username
	 * @return
	 */
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
