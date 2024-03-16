package com.ayoub.real_estate.business.services;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ayoub.real_estate.business.dao.CityDao;
import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.mappers.CityMapper;
import com.ayoub.real_estate.modules.city;
import com.ayoub.real_estate.modules.args.args;


@Service
public class CityService extends ContextFactory implements CityDao {

	@Override
	public city get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(city a) {
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
	public List<city> getAll() {
		String SQL ="select * FROM city";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.query(
				   SQL, new CityMapper());
	}

	@Override
	public List<city> Search(args Args) {
		// TODO Auto-generated method stub
		return null;
	}

}
