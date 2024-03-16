package com.ayoub.real_estate.modules.args;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.modules.proprety;
import com.ayoub.real_estate.modules.interfaces.propretyAttribute;


@Component
@Scope("prototype")
public class propretyArgs extends proprety implements args {
		
	public propretyArgs(Integer id) {
		super(id);
	}

	public HashMap<String, Object> getNonNullAttributes() throws IllegalArgumentException, IllegalAccessException {
		
		
		HashMap<String, Object> fields = new HashMap<String, Object>();

		if(this.id == null ) {
			return null;
		}
		  
		  for(Field f : getClass().getSuperclass().getDeclaredFields()) {
			  if (f.get(this) != null) {
				  fields.put(f.getName(), f.get(this));
			  }
		  }
		  return fields;
	}
	
	
	
	  
	 
}
