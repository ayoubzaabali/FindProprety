package com.ayoub.real_estate.business.services;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ayoub.real_estate.business.dao.NatureDao;
import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.mappers.CityMapper;
import com.ayoub.real_estate.business.mappers.NatureMapper;
import com.ayoub.real_estate.modules.city;
import com.ayoub.real_estate.modules.nature;
import com.ayoub.real_estate.modules.args.args;


@Service
public class NatureService extends ContextFactory implements NatureDao {

	@Override
	public nature get(int id) {
		String SQL ="SELECT * FROM\r\n"
				+ "type WHERE \r\n"
				+ "id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.queryForObject(
				   SQL ,new NatureMapper(),id);
	}

	@Override
	public void add(nature a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());
		String SQL = "DELETE FROM `type` WHERE id=?";
		vJdbcTemplate.update( SQL, id );	
	}


	@Override
	public void update(args Args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<nature> getAll() {
		String SQL ="select * FROM type";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(DataSource());

		return  vJdbcTemplate.query(
				   SQL, new NatureMapper());
	}

	@Override
	public List<nature> Search(args Args) {
		// TODO Auto-generated method stub
		return null;
	}

}
