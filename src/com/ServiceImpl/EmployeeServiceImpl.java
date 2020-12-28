package com.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DAOImpl.DepartmentDAOImpl;
import com.DAOImpl.EmployeeDAOImpl;
import com.DTO.EmployeeDTO;
import com.Service.CRUDService;

public class EmployeeServiceImpl implements CRUDService<EmployeeDTO>{

	EmployeeDAOImpl employeeDAOImpl;
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

	
	public EmployeeServiceImpl() throws SQLException {
		
		employeeDAOImpl = new EmployeeDAOImpl();
		
	}
	
	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		
		try {
			return this.employeeDAOImpl.save(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) {
		try {
			return this.employeeDAOImpl.update(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> retrieveAll() {
		try {
			return this.employeeDAOImpl.retrieveAll();
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public boolean remove(EmployeeDTO dto) {
		try {
			return this.employeeDAOImpl.remove(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return false;
		}
	}

	@Override
	public EmployeeDTO getUsingID(long id) {
		try {
			return this.employeeDAOImpl.retrieveById(id);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public EmployeeDTO retrieveByName(String name) {
		try {
			return this.employeeDAOImpl.retrieveByName(name);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

}
