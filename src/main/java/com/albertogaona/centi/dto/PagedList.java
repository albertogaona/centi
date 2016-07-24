package com.albertogaona.centi.dto;

import java.util.List;

public class PagedList<T> {
	
	private int totalRecords;
	private List<T> data;
	
	public PagedList(int totalRecords, List<T> data) {
		this.totalRecords = totalRecords;
		this.data = data;
	}

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	
	

}
