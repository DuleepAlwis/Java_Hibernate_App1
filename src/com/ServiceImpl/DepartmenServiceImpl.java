package com.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DAOImpl.DepartmentDAOImpl;
import com.DTO.DepartmentDTO;
import com.Service.CRUDService;

public class DepartmenServiceImpl implements CRUDService<DepartmentDTO>{

	DepartmentDAOImpl departmentDAOImpl;
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

	public DepartmenServiceImpl() throws SQLException {
		
		
		departmentDAOImpl = new DepartmentDAOImpl();
		
	}
	
	@Override
	public DepartmentDTO save(DepartmentDTO dto) {
		
		try {
			return this.departmentDAOImpl.save(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
		
	}

	@Override
	public DepartmentDTO update(DepartmentDTO dto) {
		
		try {
			return this.departmentDAOImpl.update(dto);
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<DepartmentDTO> retrieveAll() {
		
		try {
			return this.departmentDAOImpl.retrieveAll();
			
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
		
	}

	@Override
	public boolean remove(DepartmentDTO dto) {
		
		try {
			return this.departmentDAOImpl.remove(dto);
			
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return false;
		}
		
	}

	@Override
	public DepartmentDTO getUsingID(long id) {
		try {
			return this.departmentDAOImpl.retrieveById(id);
			
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
	}

	@Override
	public DepartmentDTO retrieveByName(String name) {
		try {
			return this.departmentDAOImpl.retrieveByName(name);
			
		} catch (SQLException e) {
			logger.log(Level.WARNING,e.getMessage());
			return null;
		}
		
	}
	
	
	
	

}
