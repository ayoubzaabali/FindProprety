package com.ayoub.real_estate.business.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.factory.Services;
import com.ayoub.real_estate.modules.city;
import com.ayoub.real_estate.modules.nature;
import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.proprety;

@Component
public class PropretyMapper extends ContextFactory implements RowMapper<proprety> {

	@Override
	public proprety mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//set proprety id
		proprety p = (proprety) Context().getBean("proprety",rs.getInt("id"));
		
		
		
		//get city
	     city City = (city) Context().getBean("city",rs.getInt("city_id"));
	     City.setLabel(rs.getString("city_label"));
    	 
	   //get type
    	 nature Nature = (nature) Context().getBean("nature",rs.getInt("type_id"));
    	 Nature.setLabel(rs.getString("type_label"));
    	 
    	//get amenities
    	 List<amenity> amenities=(List<amenity>) Services.propretyService().getAmenities(rs.getInt("id"));
    	 	
		
		
		 return p
				.setAdress(  rs.getString("adress") )
				.setPrice( rs.getInt("price") )
				.setBathrooms( rs.getInt("bathrooms") )
				.setBedrooms( rs.getInt("bedrooms") )
				.setCreate_time( rs.getDate("create_time"))
				.setPets_allowed( rs.getBoolean("pets_allowed") )
				.setFor_rent(rs.getInt("for_rent"))
		        .setSquare_metters(rs.getInt("square_metters") )
		        .setDescription(rs.getString("description") )
		        .setCity(City)
		        .setNature(Nature)
		        .setAmenities(amenities).setFrontPhoto( rs.getString("front_photo") );
		
		
	}
	
	
	public static JSONObject Schema() {
		JSONObject shema = new JSONObject();
		shema.put("id", "id");
		shema.put("price", "price");
		shema.put("bedrooms", "bedrooms");
		shema.put("bathrooms", "bathrooms");
		shema.put("pets_allowed", "pets_allowed");
		shema.put("adress", "adress");
		shema.put("for_rent", "for_rent");
		shema.put("square_metters", "square_metters");
		shema.put("city", "city_id");
		shema.put("nature", "type_id");
		shema.put("create_time", "create_time");
		shema.put("description", "description");
		shema.put("frontPhoto", "front_photo");
		
		return(shema);
	}

}
