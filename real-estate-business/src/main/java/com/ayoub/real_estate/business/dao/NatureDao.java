package com.ayoub.real_estate.business.dao;

import java.util.List;

import com.ayoub.real_estate.modules.nature;
import com.ayoub.real_estate.modules.args.args;

public interface NatureDao {
	public nature get(int id);
    public void add(nature a);
    public void remove(int id);
    public void update(args Args) throws IllegalArgumentException, IllegalAccessException;
    public List<nature> getAll();
    public List<nature> Search(args Args);
    
}
