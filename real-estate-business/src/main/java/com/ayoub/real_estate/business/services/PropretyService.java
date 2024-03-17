package com.ayoub.real_estate.business.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;


import com.ayoub.real_estate.business.dao.PropretyDao;
import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.mappers.PropretyMapper;
import com.ayoub.real_estate.business.mappers.AmenityMapper;
import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.proprety;
import com.ayoub.real_estate.modules.args.args;
import com.ayoub.real_estate.modules.interfaces.propretyAttribute;


@Service
public class PropretyService extends ContextFactory implements PropretyDao {



	
	@Override
	public proprety get(int id) {
		
		String SQL ="select\r\n"
				+ "proprety.*,\r\n"
				+ "\r\n"
				+ "type.id as type_id,\r\n"
				+ "type.label as type_label,\r\n"
				+ "\r\n"
				+ "city.id as city_id,\r\n"
				+ "city.label as city_label\r\n"
				+ "\r\n"
				+ "FROM\r\n"
				+ "\r\n"
				+ "proprety\r\n"
				+ "LEFT JOIN type ON proprety.type_id=type.id\r\n"
				+ "LEFT JOIN city ON city_id=city.id \r\n"
				+ "\r\n"
				+ "WHERE proprety.id=? \r\n"
				+ "\r\n"
				+ "GROUP by proprety.id";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.queryForObject(
				   SQL ,new PropretyMapper(),id);
	}

	@Override
	public List<proprety> getAll() {
		String SQL ="select\r\n"
				+ "proprety.*,\r\n"
				+ "\r\n"
				+ "type.id as type_id,\r\n"
				+ "type.label as type_label,\r\n"
				+ "\r\n"
				+ "city.id as city_id,\r\n"
				+ "city.label as city_label\r\n"
				+ "\r\n"
				+ "FROM\r\n"
				+ "\r\n"
				+ "proprety\r\n"
				+ "LEFT JOIN type ON proprety.type_id=type.id\r\n"
				+ "LEFT JOIN city ON city_id=city.id \r\n"
				+ "			\r\n"
				+ "GROUP by proprety.id";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.query(
				   SQL, new PropretyMapper());
	}

	@Override
	public void add(proprety p) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(int id) {
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());
		String SQL = "DELETE FROM `proprety` WHERE id=?";
		vJdbcTemplate.update( SQL, id );	
	}

	
	@Override
	public int update(args Args) throws IllegalArgumentException, IllegalAccessException {
		// i still need to implement list of amenities update 
		
        
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());
		StringBuilder SQL= new StringBuilder();
		SQL.append("UPDATE proprety SET \r\n");

		//get all data base schema names
		JSONObject shemaDb=PropretyMapper.Schema();
		
		
		//get fields to updates (java attributes)
		HashMap<String, Object> Attributes=Args.getNonNullAttributes();
		
		// iterate fields to updates 
		Set<String> keys=Attributes.keySet();
		
		//instance of keys iterator
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			
	    //get db name of the field
		 String atrr=iterator.next();
		 
		 // append db name of the field to the query
		 SQL.append(shemaDb.get(atrr));
		 SQL.append("=");
		 
		 //get Attribute Values
		 if(atrr.equals("city") || atrr.equals("nature") ) {
			 SQL.append( ((propretyAttribute) Attributes.get(atrr)).getId().toString() ); 
			    /*if( ((propretyAttribute) Attributes.get(atrr)).getId().toString().equals("4") ) {
			    	return(404);
			    	//throw new DataIntegrityViolationException("city doesn't exist");
			    }*/
		 }else {
			 SQL.append("'" +Attributes.get(atrr) +"'" ); 
		 }
		
		 // add comma and spaces
	     if(iterator.hasNext()) {
			 SQL.append(",");
		 }else {
			 SQL.append("\r\n");
		 }
		 
	   }
		//	*********************end of while*******************
		
		
		SQL.append("WHERE id=");
		SQL.append(Attributes.get("id"));
	

		
		return( vJdbcTemplate.update(SQL.toString()));

		
		
		
	}

	@Override
	public List<proprety> Search(args Args) throws IllegalArgumentException, IllegalAccessException {
		
		String SQLQuery ="select\r\n"
				+ "proprety.*,\r\n"
				+ "\r\n"
				+ "type.id as type_id,\r\n"
				+ "type.label as type_label,\r\n"
				+ "\r\n"
				+ "city.id as city_id,\r\n"
				+ "city.label as city_label\r\n"
				+ "\r\n"
				+ "FROM\r\n"
				+ "\r\n"
				+ "proprety\r\n"
				+ "LEFT JOIN type ON proprety.type_id=type.id\r\n"
				+ "LEFT JOIN city ON city_id=city.id \r\n"
				+ "			\r\n";
		
		StringBuilder SQL= new StringBuilder(SQLQuery);
		
		   //get fields to updates (java attributes)
	        HashMap<String, Object> Attributes=Args.getNonNullAttributes();
		
	       //get all data base schema names
	  		JSONObject shemaDb=PropretyMapper.Schema();
	  		
	  	    // iterate fields to updates 
			Set<String> keys=Attributes.keySet();
	  		
			//remove id from keyset
			keys.remove("id");
			
			
	  	    //instance of keys iterator
			Iterator<String> iterator = keys.iterator();
			
			
			//check if attributes size is 0
	  		if(Attributes.size()!=0) {
	  			 SQL.append("WHERE ");
	  		//loop through attributes
	  		while(iterator.hasNext()) {
				
	  		    //get db name of the field
	  			 String atrr=iterator.next();
	  			 
	  			 // append db name of the field to the query
	  				SQL.append(shemaDb.get(atrr));
	  				if(atrr.equals("price") ) 
	  				{
	  					SQL.append("<="); 
	  				}else if( atrr.equals("create_time")) {
	  					SQL.append(">="); 
	  				}else 
	  				{
	  					SQL.append("="); 
	  				}
		  			 
	  			
	  			 
	  			 
	  			 //get Attribute Values
	  			 if(atrr.equals("city") || atrr.equals("nature") ) {
	  				 SQL.append( ((propretyAttribute) Attributes.get(atrr)).getId().toString() ); 
	  				    /*if( ((propretyAttribute) Attributes.get(atrr)).getId().toString().equals("4") ) {
	  				    	return(404);
	  				    	//throw new DataIntegrityViolationException("city doesn't exist");
	  				    }*/
	  			 }else {
	  				if(atrr.equals("price")) {
	  					SQL.append(Attributes.get(atrr));
	  				}else {
	  					SQL.append("'" +Attributes.get(atrr) +"'" );

	  				}
	  			 }
	  				  			 
	  			 // add comma and spaces
	  		     if(iterator.hasNext()) {
	  				 SQL.append(" and ");
	  			 }else{
	  				 SQL.append("\r\n");
	  			 }
	  			 
	  		   }
	  		SQL.append("GROUP by proprety.id");
	  		}
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		System.out.println(SQL.toString());
		
		return  vJdbcTemplate.query(
		      SQL.toString(), new PropretyMapper());
		
	}

	@Override
	public List<amenity> getAmenities(int proprety_id) {
		String SQL ="select \r\n"
				+ "\r\n"
				+ "amenity.id,\r\n"
				+ "amenity.label\r\n"
				+ "\r\n"
				+ "FROM\r\n"
				+ "proprety INNER JOIN proprety_has_amenity pha1 ON pha1.proprety_id=proprety.id,\r\n"
				+ "amenity INNER JOIN proprety_has_amenity pha2 ON pha2.Amenity_id=amenity.id\r\n"
				+ "\r\n"
				+ "WHERE proprety.id=? \r\n"
				+ "\r\n"
				+ "GROUP by proprety.id,amenity.id;\r\n"
				+ "";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.query(
				   SQL, new AmenityMapper(),proprety_id);
	}

	@Override
	public void updateAmenity(int proprety_id,int amenity_id) {
		NamedParameterJdbcTemplate  vJdbcTemplate = new NamedParameterJdbcTemplate(DataSource());
		
		String SQL= "UPDATE proprety_has_amenity SET Amenity_id=:amenity_id WHERE proprety_id=:proprety_id";
		
		 MapSqlParameterSource paramSource = new MapSqlParameterSource();
		 paramSource.addValue("amenity_id", amenity_id);
		 paramSource.addValue("proprety_id", proprety_id);
		 
		 vJdbcTemplate.update(SQL,paramSource);
	}






}
