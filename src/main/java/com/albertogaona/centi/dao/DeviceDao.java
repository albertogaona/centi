package com.albertogaona.centi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.albertogaona.centi.bean.Device;
import com.albertogaona.centi.dto.PagedList;
import com.albertogaona.centi.dto.PagingRequest;

@Repository
public class DeviceDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Device> findAll() {
		return jdbcTemplate.query(""
				+ "SELECT id, "
				+ "name, "
				+ "lat, "
				+ "lng, "
				+ "last_update "
				+ "FROM device", new RowMapper<Device>() {

			@Override
			public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
				Device device = new Device();
				device.setId(rs.getInt("id"));
				device.setName(rs.getString("name"));
				device.setLat(rs.getDouble("lat"));
				device.setLng(rs.getDouble("lng"));
				device.setLastUpdate(rs.getDate("last_update"));
				System.out.println(String.format("Device=%s", device.getName()));
				return device;
			}
		});
	}
	
	public PagedList<Device>findPage(final PagingRequest pagingRequest) {
		String orderColumn = pagingRequest.getColumnData()[pagingRequest.getOrderColumn()];
		
		List<Device> devices = jdbcTemplate.query(
				"SELECT id, "
						+ "name, "
						+ "lat, "
						+ "lng, "
						+ "last_update "
						+ "FROM device "
						+ "WHERE	1=1 " 
						+ String.format("ORDER BY %s %s ", orderColumn, pagingRequest.getOrderDir())
						+ String.format("LIMIT %s OFFSET %s ", pagingRequest.getLength(), pagingRequest.getStart()) 
						, new RowMapper<Device>() {
							@Override
							public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
								Device device = new Device();
								device.setId(rs.getInt("id"));
								device.setName(rs.getString("name"));
								device.setLat(rs.getDouble("lat"));
								device.setLng(rs.getDouble("lng"));
								device.setLastUpdate(rs.getDate("last_update"));
								System.out.println(String.format("Device=%s", device.getName()));
								return device;
							}
						});
		int totalRecords = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) "
				+ "FROM device "
				+ "WHERE 1=1"
				, int.class);
		return new PagedList<Device>(totalRecords, devices);
	}

}
