package com.ayoub.real_estate.modules.args;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.modules.city;


@Component
@Scope("prototype")
public class cityArgs extends city implements args {
		

	public cityArgs(Integer id) {
		super(id);
	}

	public HashMap<String, Object> getNonNullAttributes() throws IllegalArgumentException, IllegalAccessException {
		
		
		HashMap<String, Object> fields = new HashMap<String, Object>();

		if(this.id == null ) {
			System.out.println("no id ");
			return null;
		}
		  
		  for(Field f : getClass().getSuperclass().getDeclaredFields()) {
			  if (f.get(this) != null) {
				  fields.put(f.getName(), f.get(this));
			  }
		  }
		  if(!this.id.equals(null)) {
			  fields.put("id", this.id);
		  }
		  return fields;
	}

	
	
	
	
	  
	 
}
