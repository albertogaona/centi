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

package com.albertogaona.centi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albertogaona.centi.bean.Device;
import com.albertogaona.centi.dto.PagedList;
import com.albertogaona.centi.dto.PagingRequest;
import com.albertogaona.centi.service.DeviceService;

/**
 * Created by alberto on 19/06/16.
 */
@Controller
public class DefaultController {

	@Autowired
	private DeviceService deviceService;
	
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/getDevices")
    public @ResponseBody Map<String, Object>getDevices(HttpServletRequest request) {
    	PagingRequest pagingRequest = new PagingRequest();
    	int start = Integer.parseInt(request.getParameter("start"));
    	int length = Integer.parseInt(request.getParameter("length"));
    	int orderColumn = Integer.parseInt(request.getParameter("order[0][column]"));
    	
    	pagingRequest.setStart(start);
    	pagingRequest.setLength(length);
    	pagingRequest.setSearch(request.getParameter("search"));
    	pagingRequest.setOrderDir(request.getParameter("order[0][dir]"));
    	pagingRequest.setOrderColumn(orderColumn);
    	pagingRequest.setColumnData(new String[]{"id", "name", "last_update"});
    	
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	PagedList<Device> devicePage = deviceService.findPage(pagingRequest);
    	result.put("data", devicePage.getData());
    	result.put("recordsTotal", new Integer(devicePage.getTotalRecords()));
    	result.put("recordsFiltered", new Integer(devicePage.getTotalRecords()));
    	result.put("draw", request.getParameter("draw"));
    	return result;
    }
    
    

}

