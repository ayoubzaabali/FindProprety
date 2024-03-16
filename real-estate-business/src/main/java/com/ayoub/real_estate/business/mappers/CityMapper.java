package com.ayoub.real_estate.business.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.modules.city;

@Component
public class CityMapper extends ContextFactory implements RowMapper<city> {

	@Override
	public city mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		city a = (city) Context().getBean("city",rs.getInt("id"));
		
		return (city) a
				.setLabel(  rs.getString("label") );
	}
	
	
	public static JSONObject Schema() {
		JSONObject shema = new JSONObject();
		shema.put("id", "id");
		shema.put("label", "label");
	
		
		return(shema);
	}

}
