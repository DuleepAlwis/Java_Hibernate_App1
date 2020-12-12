package com.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.DAOImpl.DepartmentDAOImpl;
import com.DTO.DepartmentDTO;
import com.Service.CRUDService;

public class DepartmenServiceImpl implements CRUDService<DepartmentDTO>{

	DepartmentDAOImpl departmentDAOImpl;
	public DepartmenServiceImpl() throws SQLException {
		
		departmentDAOImpl = new DepartmentDAOImpl();
		
	}
	
	@Override
	public DepartmentDTO save(DepartmentDTO dto) {
		
		return this.departmentDAOImpl.save(dto);
		
	}

	@Override
	public DepartmentDTO update(DepartmentDTO dto) {
		return this.departmentDAOImpl.update(dto);
	}

	@Override
	public ArrayList<DepartmentDTO> retrieveAll() {
		return this.departmentDAOImpl.retrieveAll();
	}

	@Override
	public boolean remove(DepartmentDTO dto) {
		return this.departmentDAOImpl.remove(dto);
	}

	@Override
	public DepartmentDTO getUsingID(long id) {
		return this.departmentDAOImpl.retrieveById(id);
	}

	@Override
	public DepartmentDTO retrieveByName(String name) {
		return this.departmentDAOImpl.retrieveByName(name);
		
	}
	
	
	
	

}
