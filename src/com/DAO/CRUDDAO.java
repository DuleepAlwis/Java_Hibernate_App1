package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DTO.DepartmentDTO;
import com.DTO.EmployeeDTO;

public interface CRUDDAO<T> {

	public T save(T dto) throws SQLException;
	public T update(T dto) throws SQLException;
	public T retrieveById(long id) throws SQLException;
	public T retrieveByName(String name) throws SQLException;
	public List<T> retrieveAll() throws SQLException;
	public boolean remove(T dto) throws SQLException;
}
