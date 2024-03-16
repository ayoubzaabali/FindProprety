package com.ayoub.real_estate.modules;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.modules.interfaces.propretyAttribute;


@Component
@Scope("prototype")
public class city implements propretyAttribute {
	protected Integer id;
	protected String label;

	
	public city(Integer id) {
		this.id=id;
   }
	
	public String getLabel() {
		return label;
	}
    
	public propretyAttribute setLabel(String label) {
		this.label = label;
		return this;
	}

	
	public Integer getId() {
		return id;
	}




}
