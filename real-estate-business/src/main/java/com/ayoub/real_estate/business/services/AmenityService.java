package com.ayoub.real_estate.business.services;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ayoub.real_estate.business.dao.AmenityDao;
import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.mappers.AmenityMapper;
import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.args.args;


@Service
public class AmenityService extends ContextFactory implements AmenityDao   {

	@Override
	public amenity get(int id) {
		String SQL ="SELECT * FROM\r\n"
				+ "amenity WHERE \r\n"
				+ "id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.queryForObject(
				   SQL ,new AmenityMapper(),id);
	}

	@Override
	public void add(amenity a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(args Args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<amenity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public amenity Search(args Args) throws IllegalArgumentException, IllegalAccessException {
		return null;
	}

}
