package com.albertogaona.centi.dto;

/**
 * A paging request to fetch data from a data store. 
 * 
 * @author Alberto Gaona
 *
 */
public class PagingRequest {
	/**
	 * First record from the ordered list.
	 */
	private int start;
	/**
	 * Page length.
	 */
	private int length;
	
	/**
	 * Search parameter (May be null).
	 */
	private String search;
	
	/**
	 * Column names.
	 */
	private String [] columnData;
	
	/**
	 * Index of column to sort
	 */
	private int orderColumn;
	
	/**
	 * Sort direction (may be "asc" or "desc")
	 */
	private String orderDir;

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return the columnData
	 */
	public String[] getColumnData() {
		return columnData;
	}

	/**
	 * @param columnData the columnData to set
	 */
	public void setColumnData(String[] columnData) {
		this.columnData = columnData;
	}

	/**
	 * @return the orderColumn
	 */
	public int getOrderColumn() {
		return orderColumn;
	}

	/**
	 * @param orderColumn the orderColumn to set
	 */
	public void setOrderColumn(int orderColumn) {
		this.orderColumn = orderColumn;
	}

	/**
	 * @return the orderDir
	 */
	public String getOrderDir() {
		return orderDir;
	}

	/**
	 * @param orderDir the orderDir to set
	 */
	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
	
}
