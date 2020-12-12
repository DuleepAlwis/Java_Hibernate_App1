package com.Service;

import java.util.ArrayList;

public interface CRUDService<T> {

	public T save(T dto);
	public T update(T dto);
	public ArrayList<T> retrieveAll();
	public boolean remove(T dto);
	public T getUsingID(long id);
	public T retrieveByName(String name);
}
