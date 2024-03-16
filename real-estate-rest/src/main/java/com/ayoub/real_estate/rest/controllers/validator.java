package com.ayoub.real_estate.rest.controllers;

import org.springframework.stereotype.Component;

@Component
public class validator {

	public static boolean isNull(Object item) {
		return item==null;
	}
}
