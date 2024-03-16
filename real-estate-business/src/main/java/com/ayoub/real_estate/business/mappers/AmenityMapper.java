package com.ayoub.real_estate.business.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.modules.amenity;

@Component
public class AmenityMapper extends ContextFactory implements RowMapper<amenity> {

	@Override
	public amenity mapRow(ResultSet rs, int rowNum) throws SQLException {
		amenity a = (amenity) Context().getBean("amenity",rs.getInt("id"));
		
		return (amenity) a
				.setLabel(  rs.getString("label") );
	}
	
	
	public static JSONObject Schema() {
		JSONObject shema = new JSONObject();
		shema.put("id", "id");
		shema.put("label", "label");
	
		
		return(shema);
	}

}
