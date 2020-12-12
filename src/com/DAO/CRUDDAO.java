package com.DAO;

import java.util.ArrayList;

public interface CRUDDAO<T> {

	public T save(T dto);
	public T update(T dto);
	public T retrieveById(long id);
	public T retrieveByName(String name);
	public ArrayList<T> retrieveAll();
	public boolean remove(T dto);
}
