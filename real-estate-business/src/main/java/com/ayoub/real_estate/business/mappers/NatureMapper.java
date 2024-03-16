package com.ayoub.real_estate.business.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.modules.nature;

@Component
public class NatureMapper extends ContextFactory implements RowMapper<nature> {

	@Override
	public nature mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		System.out.println(rs.getInt("id"));
		nature a = (nature) Context().getBean("nature",rs.getInt("id"));
		
		return (nature) a
				.setLabel(  rs.getString("label") );
	}
	
	
	public static JSONObject Schema() {
		JSONObject shema = new JSONObject();
		shema.put("id", "id");
		shema.put("label", "label");
	
		
		return(shema);
	}

}
