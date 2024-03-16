package com.ayoub.real_estate.business.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.proprety;
import com.ayoub.real_estate.modules.args.args;

/**
 * Hello world!
 *
 */
public interface PropretyDao
{
	public proprety get(int id);
    public void add(proprety p);
    public void remove(int id);
    public int update(args Args) throws IllegalArgumentException, IllegalAccessException;
    public List<proprety> getAll();
    public List<proprety> Search(args Args) throws IllegalArgumentException, IllegalAccessException;
    public List<amenity> getAmenities(int id);
    public void updateAmenity(int proprety_id,int amenity_id);
}
