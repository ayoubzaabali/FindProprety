package com.ayoub.real_estate.business.dao;

import java.util.List;

import com.ayoub.real_estate.modules.city;
import com.ayoub.real_estate.modules.args.args;

public interface CityDao {
	public city get(int id);
    public void add(city a);
    public void remove(int id);
    public void update(args Args) throws IllegalArgumentException, IllegalAccessException;
    public List<city> getAll();
    public List<city> Search(args Args);
    
}
