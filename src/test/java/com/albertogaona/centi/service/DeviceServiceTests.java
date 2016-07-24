package com.albertogaona.centi.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.albertogaona.centi.bean.Device;
import com.albertogaona.centi.config.CentiApplication;
import com.albertogaona.centi.dto.PagedList;
import com.albertogaona.centi.dto.PagingRequest;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CentiApplication.class)
public class DeviceServiceTests {
	
	@Autowired
	DeviceService deviceService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void getAllDevices() {
		List<Device> devices = deviceService.findAll();
		assertThat(devices.size(), greaterThan(0));
	}
	
	@Test
	public void getDevicesPage() {
		PagingRequest pagingRequest = new PagingRequest();
		pagingRequest.setStart(0);
		pagingRequest.setLength(2);
		pagingRequest.setColumnData(new String[]{"name", "last_update"});
		pagingRequest.setOrderColumn(0);
		pagingRequest.setOrderDir("asc");
		
		PagedList<Device> result = deviceService.findPage(pagingRequest);
		assertThat(result.getTotalRecords(), greaterThan(0));
	}
	
}
