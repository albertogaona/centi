package com.albertogaona.centi.bean;

/**
 * A geo localizable device. 
 * @author Alberto Gaona
 *
 */
public class Device {
	/**
	 * Device ID.
	 */
	private int id;
	
	/**
	 * Device name.
	 */
	private String name;
	
	/**
	 * Device last known latitude. May be null.
	 */
	private Double lat;
	
	/**
	 * Device's last known longitude. May be null.
	 */
	private Double lng;
	
	/**
	 * Device's last position update. May be null;
	 */
	private java.util.Date lastUpdate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public Double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}

	/**
	 * @return the lastUpdate
	 */
	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(java.util.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
