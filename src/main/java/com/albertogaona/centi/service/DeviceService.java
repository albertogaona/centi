package com.albertogaona.centi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertogaona.centi.bean.Device;
import com.albertogaona.centi.dao.DeviceDao;
import com.albertogaona.centi.dto.PagedList;
import com.albertogaona.centi.dto.PagingRequest;

@Service
public class DeviceService {
	
	@Autowired
	DeviceDao deviceDao;
	
	public List<Device>findAll() {
		return deviceDao.findAll();
	}
	
	public PagedList<Device>findPage(final PagingRequest pageDetail) {
		return deviceDao.findPage(pageDetail);
	}

}
