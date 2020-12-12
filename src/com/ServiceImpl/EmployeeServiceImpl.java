package com.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.DAOImpl.DepartmentDAOImpl;
import com.DAOImpl.EmployeeDAOImpl;
import com.DTO.EmployeeDTO;
import com.Service.CRUDService;

public class EmployeeServiceImpl implements CRUDService<EmployeeDTO>{

	EmployeeDAOImpl employeeDAOImpl;
	
	public EmployeeServiceImpl() throws SQLException {
		
		employeeDAOImpl = new EmployeeDAOImpl();
		
	}
	
	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmployeeDTO> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeDTO getUsingID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO retrieveByName(String name) {
		return this.employeeDAOImpl.retrieveByName(name);
	}

}
