package com.ayoub.real_estate.business.factory;


import com.ayoub.real_estate.business.services.*;

public class Services {
	
	private final static PropretyService propretyService= new PropretyService();
	private final static CityService cityService= new CityService();
	private final static AmenityService amenityService= new AmenityService();
	private final static NatureService natureService= new NatureService();
	
	
	public static PropretyService propretyService() {
		return propretyService;
	}


	public static CityService Cityservice() {
		return cityService;
	}


	public static AmenityService Amenityservice() {
		return amenityService;
	}


	public static NatureService Natureservice() {
		return natureService;
	}
	
	

}
