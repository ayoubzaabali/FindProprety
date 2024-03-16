package com.ayoub.real_estate.business.dao;

import java.util.List;

import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.args.args;

public interface AmenityDao {
	public amenity get(int id);
    public void add(amenity a);
    public void remove(int id);
    public void update(args Args) throws IllegalArgumentException, IllegalAccessException;
    public List<amenity> getAll();
    public amenity Search(args Args) throws IllegalArgumentException, IllegalAccessException;
}
