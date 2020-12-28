package com.Service;

import java.util.ArrayList;
import java.util.List;

import com.DTO.DepartmentDTO;
import com.DTO.EmployeeDTO;

public interface CRUDService<T> {

	public T save(T dto);
	public T update(T dto);
	public List<T> retrieveAll();
	public boolean remove(T dto);
	public T getUsingID(long id);
	public T retrieveByName(String name);
}
